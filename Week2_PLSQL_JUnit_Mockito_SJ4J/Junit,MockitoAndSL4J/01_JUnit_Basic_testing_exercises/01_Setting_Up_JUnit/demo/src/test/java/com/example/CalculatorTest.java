package com.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CalculatorTest{
    @Test
    public void testAdd(){
        Calculator calculator =new Calculator();
        int res=calculator.add(2,3);
        assertEquals(5,res);
    }
}