package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тест на класс TrgArea.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class TrgAreaTest {

    /**
     * Тестируем создание экземпляра класса TrgArea.
     */
    @Test
    public void whenCreateObject() {
        TrgArea trgArea = new TrgArea();
        Assert.assertNotNull(trgArea);
    }

    /**
     * Тестируем получение площади по длина трех сторон.
     */
    @Test
    public void area() {
        double first = 2;
        double second = 2;
        double third = 2;
        double expected = 1.73;
        double s = TrgArea.area(first, second, third);
        Assert.assertEquals(expected, s, 0.01);
    }
}