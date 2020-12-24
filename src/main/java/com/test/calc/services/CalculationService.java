package com.test.calc.services;

public interface CalculationService {

    /**
     * @param a the first number
     * @param b the second number
     * @return sum two numbers
     */
    Integer add(Integer a, Integer b);

    /**
     * @param a the first number
     * @param b the second number
     * @return subtract two numbers
     */
    Integer subtract(Integer a, Integer b);

    /**
     * @param a the first number
     * @param b the second number
     * @return multiply two numbers
     */
    Integer multiply(Integer a, Integer b);

    /**
     * @param a the first number
     * @param b the second number
     * @return integer part of the division of two numbers
     */
    Integer divide(Integer a, Integer b);
}
