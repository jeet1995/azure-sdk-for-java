package com.azure.communication.common.perf;

import com.azure.perf.test.core.PerfStressProgram;

/**
 * Runs the Azure-Communication-Common performance test.
 *
 * <p>To run from command line. Package the project into a jar with dependencies via mvn clean package.
 * Then run the program via java -jar 'compiled-jar-with-dependencies-path' </p>
 *
 * <p> To run from IDE, set all the required environment variables in IntelliJ via Run -&gt; EditConfigurations section.
 * Then run the App's main method via IDE.</p>
 */
public class App {
    public static void main(String[] args) {
        PerfStressProgram.run(new Class<?>[] { HmacAuthenticationPolicyTest.class }, args);
    }
}
