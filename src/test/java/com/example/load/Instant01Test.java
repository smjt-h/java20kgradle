package com.example.load;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
final class Instant01Test {

    @Test
    void tenSecondDelayOne() throws InterruptedException {
        Thread.sleep(10_000);
        assertTrue(true);
    }

    @Test
    void tenSecondDelayTwo() throws InterruptedException {
        Thread.sleep(10_000);
        assertTrue(true);
    }

    @Test
    void fiveSecondDelayOne() throws InterruptedException {
        Thread.sleep(5_000);
        assertTrue(true);
    }

    @TestFactory
    Stream<DynamicTest> instantTests() {
        return LoadTestSupport.instantTests("instant_", 1, 799);
    }
}
