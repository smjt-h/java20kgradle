package com.example.load;

import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
final class TenSecondDelay02Test {

    @TestFactory
    Stream<DynamicTest> tenSecondDelayTests() {
        return LoadTestSupport.delayTests("tenSecondDelay_", 401, 800, 10_000);
    }
}
