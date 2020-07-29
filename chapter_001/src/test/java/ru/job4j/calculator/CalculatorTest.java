package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тест-класс для Calculator.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class CalculatorTest {

    /**
     * Тестируем создание экземпляра класса Calculator.
     */
    @Test
    public void createClass() {
        Calculator calculator = new Calculator();
        Assert.assertNotNull(calculator);
    }

    /**
     * Тестируем сложение двух чисел.
     */
    @Test
    public void add() {
        Assert.assertEquals(Calculator.add(1.0, 3.0), 4.0, 0.01);
        Assert.assertEquals(Calculator.add(4.6, 3.4), 8.0, 0.01);
    }

    /**
     * Тестируем деление двух чисел.
     */
    @Test
    public void div() {
        Assert.assertEquals(Calculator.div(6.0, 3.0), 2.0, 0.01);
        Assert.assertEquals(Calculator.div(4.4, 1.1), 4.0, 0.01);
    }

    /**
     * Тестируем умножение двух чисел.
     */
    @Test
    public void multiple() {
        Assert.assertEquals(Calculator.multiple(1.0, 3.0), 3.0, 0.01);
        Assert.assertEquals(Calculator.multiple(4.5, 3.0), 13.5, 0.01);
    }

    /**
     * Тестируем вычитание двух чисел.
     */
    @Test
    public void subtract() {
        Assert.assertEquals(Calculator.subtract(3.0, 1.0), 2.0, 0.01);
        Assert.assertEquals(Calculator.subtract(4.6, 3.4), 1.2, 0.01);
    }
}