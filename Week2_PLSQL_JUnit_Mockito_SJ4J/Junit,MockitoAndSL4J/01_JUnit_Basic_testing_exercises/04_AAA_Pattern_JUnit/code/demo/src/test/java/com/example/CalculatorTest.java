package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    // Setup method - runs before each test
    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Before each test - Calculator instance created");
    }

    // Teardown method - runs after each test
    @After
    public void tearDown() {
        System.out.println("After each test - Cleanup if needed");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calc.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testMultiplication() {
        // Arrange
        int a = 4;
        int b = 3;

        // Act
        int result = calc.multiply(a, b);

        // Assert
        assertEquals(12, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 20;
        int b = 8;

        // Act
        int result = calc.subtract(a, b);

        // Assert
        assertEquals(12, result);
    }
}
