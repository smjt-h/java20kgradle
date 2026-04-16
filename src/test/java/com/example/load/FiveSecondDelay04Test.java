package com.example.load;

import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
final class FiveSecondDelay04Test {

    @TestFactory
    Stream<DynamicTest> fiveSecondDelayTests() {
        return LoadTestSupport.delayTests("fiveSecondDelay_", 2101, 2800, 5_000);
    }
}
