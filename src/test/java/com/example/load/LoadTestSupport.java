package com.example.load;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;

/** Builds dynamic instant test streams; not a test class (name does not end with {@code Test}). */
final class LoadTestSupport {

    private LoadTestSupport() {}

    static Stream<DynamicTest> instantTests(String namePrefix, int startInclusive, int endInclusive) {
        return IntStream.rangeClosed(startInclusive, endInclusive)
                .mapToObj(i -> dynamicTest(namePrefix + i, () -> assertTrue(i > 0)));
    }
}
