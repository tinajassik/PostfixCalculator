package com.example.ads_assignment1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostfixCalculatorTest {

    private PostfixCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new PostfixCalculator();
    }

    @Test
    public void testAddition() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(2));
        tokens.add(new Operand(3));
        tokens.add(new Operator("+"));

        int result = calculator.getResult(tokens);
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(5));
        tokens.add(new Operand(3));
        tokens.add(new Operator("-"));

        int result = calculator.getResult(tokens);
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(4));
        tokens.add(new Operand(5));
        tokens.add(new Operator("*"));

        int result = calculator.getResult(tokens);
        assertEquals(20, result);
    }

    @Test
    public void testDivision() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(10));
        tokens.add(new Operand(2));
        tokens.add(new Operator("/"));

        int result = calculator.getResult(tokens);
        assertEquals(5, result);
    }

    @Test
    public void testComplexExpression() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(2));
        tokens.add(new Operand(3));
        tokens.add(new Operand(1));
        tokens.add(new Operator("*"));
        tokens.add(new Operator("+"));
        tokens.add(new Operand(9));
        tokens.add(new Operator("-"));

        int result = calculator.getResult(tokens);
        assertEquals(-4, result);
    }
}
