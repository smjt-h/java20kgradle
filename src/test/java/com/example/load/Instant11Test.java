package com.example.load;

import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
final class Instant11Test {

    @TestFactory
    Stream<DynamicTest> instantTests() {
        return LoadTestSupport.instantTests("instant_", 8000, 8799);
    }
}
