package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void add_ShouldReturnSum_WhenTwoNumbersAreGiven() {
        int result = calculatorService.add(5, 7);
        assertEquals(12, result, "5 + 7 should equal 12");
    }

    @Test
    void add_ShouldHandleNegativeNumbers() {
        int result = calculatorService.add(-3, -2);
        assertEquals(-5, result, "-3 + -2 should equal -5");
    }

    @Test
    void add_ShouldHandleZero() {
        int result = calculatorService.add(0, 5);
        assertEquals(5, result, "0 + 5 should equal 5");
    }

}
