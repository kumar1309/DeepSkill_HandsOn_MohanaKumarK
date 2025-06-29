package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OddCheckerTest {

    private final OddChecker oddChecker = new OddChecker();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    void testIsOddWithOddNumbers(int number) {
        assertTrue(oddChecker.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testIsOddWithEvenNumbers(int number) {
        assertFalse(oddChecker.isOdd(number));
    }
}
