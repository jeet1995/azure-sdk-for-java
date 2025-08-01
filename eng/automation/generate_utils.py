#!/usr/bin/env python3
import os
import re
import sys
import json
import yaml
import shutil
import logging
import requests
import tempfile
import subprocess
import urllib.parse
from typing import Tuple, List, Union
from typespec_utils import validate_tspconfig

pwd = os.getcwd()
# os.chdir(os.path.abspath(os.path.dirname(sys.argv[0])))
from parameters import *
from utils import update_service_files_for_new_lib
from utils import update_root_pom
from utils import update_version
from utils import is_windows
from utils import set_or_increase_version

os.chdir(pwd)


# Add two more indent for list in yaml dump
class ListIndentDumper(yaml.SafeDumper):

    def increase_indent(self, flow=False, indentless=False):
        return super(ListIndentDumper, self).increase_indent(flow, False)


def generate(
    sdk_root: str,
    service: str,
    spec_root: str,
    readme: str,
    autorest: str,
    use: str,
    output_folder: str,
    module: str,
    namespace: str,
    tag: str = None,
    version: str = None,
    autorest_options: str = "",
    premium: bool = False,
    **kwargs,
) -> bool:
    output_dir = os.path.join(
        sdk_root,
        "sdk/{0}".format(service),
        module,
    )

    require_sdk_integration = not os.path.exists(os.path.join(output_dir, "src"))

    remove_generated_source_code(output_dir, namespace)

    if re.match(r"https?://", spec_root):
        readme = urllib.parse.urljoin(spec_root, readme)
    else:
        readme = os.path.join(spec_root, readme)

    tag_option = "--tag={0}".format(tag) if tag else ""
    version_option = "--package-version={0}".format(version) if version else ""

    command = (
        "autorest --version={0} --use={1} --java --java.java-sdks-folder={2} --java.output-folder={3} "
        "--java.namespace={4} {5}".format(
            autorest,
            use,
            os.path.abspath(sdk_root),
            os.path.abspath(output_dir),
            namespace,
            " ".join(
                (
                    tag_option,
                    version_option,
                    FLUENTPREMIUM_ARGUMENTS if premium else FLUENTLITE_ARGUMENTS,
                    autorest_options,
                    readme,
                )
            ),
        )
    )
    logging.info(command)
    if os.system(command) != 0:
        logging.error("[GENERATE] Code generation failed.")
        logging.error(
            "Please first check if the failure happens only to Java automation, or for all SDK automations. "
            "If it happens for all SDK automations, please double check your Swagger, and check whether there is errors in ModelValidation and LintDiff. "
            "If it happens to Java alone, you can open an issue to https://github.com/Azure/autorest.java/issues. Please include the link of this Pull Request in the issue."
        )
        return False

    group = GROUP_ID
    if require_sdk_integration:
        update_service_files_for_new_lib(sdk_root, service, group, module)
        update_root_pom(sdk_root, service)
    update_version(sdk_root, output_folder)

    return True


def remove_generated_source_code(sdk_folder: str, namespace: str):
    main_source_folder = os.path.join(sdk_folder, "src/main/java")
    main_resources_folder = os.path.join(sdk_folder, "src/main/resources")
    test_folder = os.path.join(sdk_folder, "src/test/java", namespace.replace(".", "/"), "generated")
    sample_folder = os.path.join(sdk_folder, "src/samples/java", namespace.replace(".", "/"), "generated")

    logging.info(f"Removing generated code from main source folder: {main_source_folder}")
    delete_generated_code(main_source_folder)
    logging.info(f"Removing files from main resources folder: {main_source_folder}")
    main_resources_folder = os.path.join(sdk_folder, "src/main/resources")
    shutil.rmtree(main_resources_folder, ignore_errors=True)

    logging.info(f"Removing generated test folder: {test_folder}")
    shutil.rmtree(test_folder, ignore_errors=True)

    logging.info(f"Removing generated samples folder: {sample_folder}")
    shutil.rmtree(sample_folder, ignore_errors=True)


def delete_generated_code(path: str) -> None:
    autorest_generated_header = "Code generated by Microsoft (R) AutoRest Code Generator"
    typespec_generated_header = "Code generated by Microsoft (R) TypeSpec Code Generator"
    if os.path.exists(path):
        for file in os.listdir(path):
            cur_path = os.path.join(path, file)
            if os.path.isdir(cur_path):
                # Recurse into subdirectory
                delete_generated_code(cur_path)
            else:
                try:
                    # Read file content and check for header
                    with open(cur_path, "r", encoding="utf-8") as f:
                        content = f.read()
                    if autorest_generated_header in content or typespec_generated_header in content:
                        os.remove(cur_path)  # Delete the file
                except Exception as e:
                    # Skip files that can't be read (binary files, permission issues)
                    print(f"Warning: Could not process file {cur_path}: {e}")
                    continue


def compile_arm_package(sdk_root: str, module: str) -> bool:
    if (
        os.system(
            "mvn --no-transfer-progress clean verify -f {0}/pom.xml -Dmaven.javadoc.skip -Dgpg.skip -DskipTestCompile -Djacoco.skip -Drevapi.skip -pl {1}:{2} -am".format(
                sdk_root, GROUP_ID, module
            )
        )
        != 0
    ):
        logging.error("[COMPILE] Maven build fail.")
        logging.error(
            'You can inquire in "Language - Java" Teams channel. Please include the link of this Pull Request in the query.'
        )
        return False
    return True


def generate_changelog_and_breaking_change(
    sdk_root,
    old_jar,
    new_jar,
    **kwargs,
) -> Tuple[bool, str]:
    logging.info("[CHANGELOG] changelog jar: {0} -> {1}".format(old_jar, new_jar))
    stdout = subprocess.run(
        'mvn --no-transfer-progress clean compile exec:java -q -f {0}/eng/automation/changelog/pom.xml -DOLD_JAR="{1}" -DNEW_JAR="{2}"'.format(
            sdk_root, old_jar, new_jar
        ),
        stdout=subprocess.PIPE,
        shell=True,
    ).stdout
    logging.info("[CHANGELOG] changelog output: {0}".format(stdout))

    config = json.loads(stdout)
    breaking_changes = config.get("breakingChanges", [])
    breaking = True if len(breaking_changes) > 0 else False
    return breaking, config.get("changelog", ""), breaking_changes


def update_changelog(changelog_file, changelog):
    version_pattern = r"^## (\d+\.\d+\.\d+(?:-[\w\d\.]+)?) \((.*?)\)"
    with open(changelog_file, "r", encoding="utf-8") as fin:
        old_changelog = fin.read()

    first_version = re.search(version_pattern, old_changelog, re.M)
    if not first_version:
        logging.error("[Changelog][Skip] Cannot read first version from {}".format(changelog_file))
        return

    left = old_changelog[first_version.end() :]
    second_version = re.search(version_pattern, left, re.M)
    if not second_version:
        logging.error("[Changelog][Skip] Cannot read second version from {}".format(changelog_file))
        return

    first_version_part = old_changelog[: first_version.end() + second_version.start()]
    # remove text starting from the first '###' (usually the block '### Features Added')
    first_version_part = re.sub(r"\n###.*", "\n", first_version_part, flags=re.S)
    first_version_part = re.sub(r"\s+$", "", first_version_part)

    first_version_part += "\n\n"
    if changelog.strip() != "":
        first_version_part += changelog.strip() + "\n\n"

    with open(changelog_file, "w", encoding="utf-8") as fout:
        fout.write(first_version_part + old_changelog[first_version.end() + second_version.start() :])

    logging.info("[Changelog][Success] Write to changelog")


def compare_with_maven_package(
    sdk_root: str, group_id: str, service: str, previous_version: str, current_version: str, module: str
):
    breaking = False
    changelog = ""
    breaking_changes = []

    if previous_version == current_version or previous_version is None:
        logging.info("[Changelog][Skip] no previous version")
    else:
        logging.info(
            "[Changelog] Compare stable version {0} with current version {1}".format(previous_version, current_version)
        )

        r = requests.get(
            MAVEN_URL.format(
                group_id=group_id.replace(".", "/"),
                artifact_id=module,
                version=previous_version,
            )
        )
        r.raise_for_status()
        old_jar_fd, old_jar = tempfile.mkstemp(".jar")
        try:
            with os.fdopen(old_jar_fd, "wb") as tmp:
                tmp.write(r.content)
            new_jar = os.path.join(
                sdk_root,
                JAR_FORMAT.format(service=service, artifact_id=module, version=current_version),
            )
            if not os.path.exists(new_jar):
                raise Exception("Cannot found built jar in {0}".format(new_jar))
            breaking, changelog, breaking_changes = generate_changelog_and_breaking_change(sdk_root, old_jar, new_jar)
            if changelog is not None:
                changelog_file = os.path.join(sdk_root, CHANGELOG_FORMAT.format(service=service, artifact_id=module))
                update_changelog(changelog_file, changelog)
            else:
                logging.error("[Changelog][Skip] Cannot get changelog")
        finally:
            os.remove(old_jar)
    return breaking, changelog, breaking_changes


def get_version(
    sdk_root: str,
    group_id: str,
    module: str,
) -> Union[str, None]:
    version_file = os.path.join(sdk_root, "eng/versioning/version_client.txt")
    project = "{0}:{1}".format(group_id, module)

    with open(version_file, "r", encoding="utf-8") as fin:
        for line in fin.readlines():
            version_line = line.strip()
            if version_line.startswith("#"):
                continue
            versions = version_line.split(";")
            if versions[0] == project:
                return version_line
    logging.error("Cannot get version of {0}".format(project))
    return None


def valid_service(service: str):
    return re.sub(r"[^a-z0-9_]", "", service.lower())


def read_api_specs(api_specs_file: str) -> Tuple[str, dict]:
    # return comment and api_specs

    with open(api_specs_file, "r", encoding="utf-8") as fin:
        lines = fin.readlines()

    comment = ""

    for i, line in enumerate(lines):
        if not line.strip().startswith("#"):
            comment = "".join(lines[:i])
            api_specs = yaml.safe_load("".join(lines[i:]))
            break
    else:
        raise Exception("api-specs.yml should has non comment line")

    return comment, api_specs


def write_api_specs(api_specs_file: str, comment: str, api_specs: dict):
    with open(api_specs_file, "w", encoding="utf-8") as fout:
        fout.write(comment)
        fout.write(yaml.dump(api_specs, width=sys.maxsize, Dumper=ListIndentDumper))


def get_and_update_service_from_api_specs(
    api_specs_file: str,
    spec: str,
    service: str = None,
    suffix: str = None,
    truncate_service: bool = False,
):
    """
    Updates the API specs file with the provided service name and optional suffix.

    Args:
        api_specs_file (str): Path to the API specs file.
        spec (str): The specification key to update in the API specs.
        service (str, optional): The service name to associate with the spec. If not provided, it will be derived.
        suffix (str, optional): An optional suffix to add to the spec entry in the API specs file.
        truncate_service (bool, optional): Whether to truncate the service name to a maximum length of 32 characters.

    Returns:
        str: The validated and potentially updated service name.
    """
    special_spec = {"resources"}
    if spec in special_spec:
        if not service:
            service = spec
        return valid_service(service)

    comment, api_specs = read_api_specs(api_specs_file)

    api_spec = api_specs.get(spec)
    if not service:
        if api_spec:
            service = api_spec.get("service")
        if not service:
            service = spec
            # remove segment contains ".", e.g. "Microsoft.KubernetesConfiguration", "Astronomer.Astro"
            service = re.sub(r"/[^/]+(\.[^/]+)+", "", service)
            # truncate length of service to 32, as this is the maximum length for package name in Java repository
            if truncate_service:
                service = valid_service(service)
                max_length = 32
                if len(service) > max_length:
                    logging.warning(f'[VALIDATE] service name truncated from "{service}" to "{service[:max_length]}"')
                    service = service[:max_length]
    service = valid_service(service)

    if service != spec:
        api_specs[spec] = dict() if not api_spec else api_spec
        api_specs[spec]["service"] = service

    if suffix:
        api_specs[spec]["suffix"] = suffix

    write_api_specs(api_specs_file, comment, api_specs)

    return service


def get_suffix_from_api_specs(api_specs_file: str, spec: str):
    comment, api_specs = read_api_specs(api_specs_file)

    api_spec = api_specs.get(spec)
    if api_spec and api_spec.get("suffix"):
        return api_spec.get("suffix")

    return None


def update_spec(spec: str, subspec: str) -> str:
    if subspec:
        spec = spec + subspec
    return spec


def generate_typespec_project(
    tsp_project: str,
    sdk_root: str,
    spec_root: str = None,
    head_sha: str = "",
    repo_url: str = "",
    remove_before_regen: bool = False,
    group_id: str = None,
    api_version: str = None,
    generate_beta_sdk: bool = True,
    version: str = None,  # SDK version
    disable_customization: bool = False,
    **kwargs,
):

    if not tsp_project:
        return False

    succeeded = False
    sdk_folder = None
    service = None
    module = None
    require_sdk_integration = False

    try:
        url_match = re.match(
            r"^https://github.com/(?P<repo>[^/]*/azure-rest-api-specs(-pr)?)/blob/(?P<commit>[0-9a-f]{40})/(?P<path>.*)/tspconfig.yaml$",
            tsp_project,
            re.IGNORECASE,
        )

        tspconfig_valid = True
        if url_match:
            # generate from remote url
            tsp_cmd_base = [
                "npx" + (".cmd" if is_windows() else ""),
                "tsp-client",
                "init",
                "--debug",
                "--tsp-config",
                tsp_project,
            ]
        else:
            # sdk automation/self serve
            tsp_dir = os.path.join(spec_root, tsp_project) if spec_root else tsp_project
            tspconfig_valid = validate_tspconfig(tsp_dir)
            repo = remove_prefix(repo_url, "https://github.com/")
            tsp_cmd_base = [
                "npx" + (".cmd" if is_windows() else ""),
                "tsp-client",
                "init",
                "--debug",
                "--tsp-config",
                tsp_dir,
                "--commit",
                head_sha,
                "--repo",
                repo,
                "--local-spec-repo",
                tsp_dir,
            ]

        if tspconfig_valid:
            emitter_options = []
            if disable_customization:
                emitter_options.append("customization-class=")
                emitter_options.append("partial-update=false")

            tsp_cmd = tsp_cmd_add_emitter_options(tsp_cmd_base, emitter_options)
            check_call(tsp_cmd, sdk_root)

            sdk_folder = find_sdk_folder(sdk_root)
            logging.info("SDK folder: " + sdk_folder)
            if sdk_folder:
                # parse service and module
                module, service = parse_service_module(sdk_folder)
                # check require_sdk_integration
                cmd = ["git", "add", "."]
                check_call(cmd, sdk_root)
                cmd = [
                    "git",
                    "status",
                    "--porcelain",
                    os.path.join(sdk_folder, "pom.xml"),
                ]
                logging.info("Command line: " + " ".join(cmd))
                output = subprocess.check_output(cmd, cwd=sdk_root)
                output_str = str(output, "utf-8")
                git_items = output_str.splitlines()
                if len(git_items) > 0:
                    git_pom_item = git_items[0]
                    # new pom.xml implies new SDK
                    require_sdk_integration = git_pom_item.startswith("A ")
                if remove_before_regen and group_id:
                    # clear existing generated source code, and regenerate
                    drop_changes(sdk_root)
                    remove_generated_source_code(sdk_folder, f"{group_id}.{service}")
                    _, current_version = set_or_increase_version(
                        sdk_root, group_id, module, version=version, preview=generate_beta_sdk
                    )

                    emitter_options.append(f"package-version={current_version}")
                    # currently for self-serve, may also need it in regular generation
                    if api_version:
                        emitter_options.append(f"api-version={api_version}")

                    tsp_cmd = tsp_cmd_add_emitter_options(tsp_cmd_base, emitter_options)
                    # regenerate
                    check_call(tsp_cmd, sdk_root)
                succeeded = True
    except subprocess.CalledProcessError as error:
        logging.error(f"[GENERATE] Code generation failed. tsp-client init fails: {error}")
        try:
            sdk_folder = find_sdk_folder(sdk_root)
            logging.info("SDK folder: " + sdk_folder)
            if sdk_folder:
                # parse service and module
                module, service = parse_service_module(sdk_folder)
            else:
                logging.info(f"[GENERATE] Code generation failed. No sdk folder found.")
        except Exception as e:
            logging.error(f"[GENERATE] Code generation failed. Finding sdk folder fails: {e}")

    return succeeded, require_sdk_integration, sdk_folder, service, module


def tsp_cmd_add_emitter_options(tsp_cmd_base: List[str], emitter_options: List[str]) -> List[str]:
    tsp_cmd = tsp_cmd_base
    if emitter_options:
        tsp_cmd.append("--emitter-options")
        tsp_cmd.append(";".join(emitter_options))
    return tsp_cmd


def parse_service_module(sdk_folder: str) -> Tuple:
    match = re.match(r"sdk[\\/](.*)[\\/](.*)", sdk_folder)
    service = match.group(1)
    module = match.group(2)
    return module, service


def check_call(cmd: List[str], work_dir: str, shell: bool = False):
    logging.info("Command line: " + " ".join(cmd))
    subprocess.check_call(cmd, cwd=work_dir, shell=shell)


def drop_changes(work_dir: str):
    check_call(["git", "reset", "--hard", "-q"], work_dir)
    check_call(["git", "clean", "-qf", "."], work_dir)


def remove_prefix(text, prefix):
    if text.startswith(prefix):
        return text[len(prefix) :]
    return text


def find_sdk_folder(sdk_root: str):
    cmd = ["git", "add", "."]
    check_call(cmd, sdk_root)

    cmd = ["git", "status", "--porcelain", "**/tsp-location.yaml"]
    logging.info("Command line: " + " ".join(cmd))
    output = subprocess.check_output(cmd, cwd=sdk_root)
    output_str = str(output, "utf-8")
    git_items = output_str.splitlines()
    sdk_folder = None
    if len(git_items) > 0:
        tsp_location_item: str = git_items[0]
        sdk_folder = tsp_location_item[1:].strip()[0 : -len("/tsp-location.yaml")]

    cmd = ["git", "reset", ".", "-q"]
    check_call(cmd, sdk_root)

    return sdk_folder


def clean_sdk_folder(sdk_root: str, sdk_folder: str) -> bool:
    succeeded = False
    # try to find the sdk_folder
    if not sdk_folder:
        sdk_folder = find_sdk_folder(sdk_root)
    if sdk_folder:
        sdk_path = os.path.join(sdk_root, sdk_folder)
        # check whether this is migration from Swagger
        if os.path.exists(os.path.join(sdk_path, "swagger")):
            print(
                "Existing package in SDK was from Swagger. It cannot be automatically converted to package from TypeSpec. Generate a fresh package from TypeSpec.",
                file=sys.stderr,
            )
        else:
            print(
                "Generate a fresh package from TypeSpec. If there was prior customization on the package, please check whether it causes failure, and fix them before apiview.",
                file=sys.stderr,
            )

        # delete the folder regardless of Swagger or not
        logging.info(f"[GENERATE] Delete folder: {sdk_folder}")
        shutil.rmtree(sdk_path, ignore_errors=True)
        succeeded = True
    return succeeded


def is_mgmt_premium(module: str) -> bool:
    return module in FLUENT_PREMIUM_PACKAGES


def copy_file_sync(source: str, target: str) -> None:
    """
    Copy a single file from source to target.

    If target is a directory, a new file with the same name will be created.

    Args:
        source: Path to the source file
        target: Path to the target file or directory
    """

    # If target is a directory, create a new file with the same name
    if os.path.exists(target) and os.path.isdir(target):
        target_file = os.path.join(target, os.path.basename(source))
    else:
        target_file = target

    # Create parent directories if they don't exist
    os.makedirs(os.path.dirname(target_file), exist_ok=True)

    # Copy the file
    shutil.copy2(source, target_file)


def copy_folder_recursive_sync(source: str, target: str) -> None:
    """
    Recursively copy a folder from source to target.
    - Only proceeds if the source folder exists
    - Creates a target folder with the same name as the source folder basename
    - Recursively copies all contents

    Args:
        source: Path to the source folder
        target: Path to the target parent directory
    """

    # Only proceed if source exists
    if not os.path.exists(source):
        return

    # Check if folder needs to be created or integrated
    target_folder = os.path.join(target, os.path.basename(source))
    os.makedirs(target_folder, exist_ok=True)

    # Copy contents if source is a directory
    if os.path.isdir(source):
        for item_name in os.listdir(source):
            item_path = os.path.join(source, item_name)
            if os.path.isdir(item_path):
                # Recursively copy subdirectories
                copy_folder_recursive_sync(item_path, target_folder)
            else:
                # Copy files
                copy_file_sync(item_path, target_folder)
