# Release History

## 12.0.0-beta.32 (Unreleased)

### Features Added
- Added more useful error message when the SDK encounters an x-ms-version mis-match issue.

### Breaking Changes

### Bugs Fixed

### Other Changes

## 12.0.0-beta.31 (2025-07-16)

### Features Added
- Added support for service version 2025-07-05.

## 12.0.0-beta.30 (2025-05-06)

### Features Added
- Added support for service version 2025-07-05.

## 12.0.0-beta.29 (2025-03-11)

### Features Added
- Added support for service version 2025-05-05.

## 12.0.0-beta.28 (2025-02-11)

### Features Added
- Added support for service version 2025-05-05.

## 12.0.0-beta.27 (2024-11-13)

### Features Added
- Added support for service version 2025-01-05.

## 12.0.0-beta.26 (2024-10-17)

### Features Added
- Added support for service version 2025-01-05.

## 12.0.0-beta.25 (2024-09-17)

### Features Added
- Added support for service version 2024-11-04.

## 12.0.0-beta.24 (2024-08-06)

### Features Added
- Added support for service version 2024-11-04.

## 12.0.0-beta.23 (2024-07-18)

### Features Added
- Added support for service version 2024-08-04.

## 12.0.0-beta.22 (2024-06-11)

### Features Added
- Added support for service version 2024-08-04.

## 12.0.0-beta.21 (2024-05-15)

### Features Added
- Added support for service versions 2024-02-04 and 2024-05-04.

## 12.0.0-beta.20 (2024-04-15)

### Features Added
- Added support for service versions 2024-02-04 and 2024-05-04.

## 12.0.0-beta.19 (2023-11-08)

### Features Added
- Added support for 2021-12-02 service version.

## 12.0.0-beta.18 (2022-05-06)

### Features Added
- Added support for 2021-06-08 service version.

## 12.0.0-beta.17 (2022-03-09)

### Other Changes

#### Dependency Updates

- Updated blob dependency to 12.15.0

## 12.0.0-beta.16 (2022-02-11)

### Other Changes

#### Dependency Updates

- Upgraded `azure-storage-blob` from `12.15.0-beta.3` to version `12.14.4`.

## 12.0.0-beta.15 (2022-02-09)

### Features Added
- Added support for 2021-04-10 service version.

## 12.0.0-beta.14 (2022-01-14)

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.23.0` to version `1.24.1`.
- Upgraded `azure-core-http-netty` from `1.11.3` to version `1.11.6`.
- Upgraded `azure-storage-blob` from `12.15.0-beta.2` to version `12.14.3`.

## 12.0.0-beta.13 (2021-12-07)

### Features Added
- Added support for 2021-02-12 service version.

## 12.0.0-beta.12 (2021-11-10)

### Other Changes

#### Dependency Updates

- Upgraded `azure-core` from `1.21.0` to version `1.22.0`.
- Upgraded `azure-core-http-netty` from `1.11.1` to version `1.11.2`.
- Upgraded `azure-storage-blob` from `12.15.0-beta.1` to version `12.14.2`.

## 12.0.0-beta.11 (2021-11-05)

### Features Added
- Added support for the 2020-12-06 service version.


## 12.0.0-beta.10 (2021-10-12)

### Other Changes
#### Dependency Updates
- Updated to version `12.14.1` of `azure-storage-blob`

## 12.0.0-beta.9 (2021-09-15)
### Other changes
- Updated blob dependency to 12.14.0

## 12.0.0-beta.8 (2021-07-28)
- Added support for the 2020-10-02 service version.

## 12.0.0-beta.7 (2021-06-09)
### Dependency updates

- Updated blob dependency to 12.12.0

## 12.0.0-beta.6 (2021-04-29)
### Dependency updates

- Updated blob dependency to 12.11.0

## 12.0.0-beta.5 (2021-01-14)
### Dependency updates

- Updated blob dependency to 12.10.0

## 12.0.0-beta.4 (2020-11-11)
### Dependency updates

- Updated blob dependency to 12.9.0

## 12.0.0-beta.3 (2020-10-01)
- Added support to specify context in the sync methods.

## 12.0.0-beta.2 (2020-08-13)
- Added the ability to read to the current hour
- Standardized continuation token behavior so that it is consistent between Azure SDK changefeed packages in other languages

## 12.0.0-beta.1 (2020-07-07)
- Initial release.
- Added support to get changefeed events for an account. 

### Features included in `azure-storage-blob-changefeed`
- This package supports changefeed for blob storage.
- Reactive streams support using [Project Reactor](https://projectreactor.io/).
