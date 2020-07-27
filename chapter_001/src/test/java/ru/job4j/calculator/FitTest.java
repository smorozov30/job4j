package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;


/**
 * Тест для класса Fit.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class FitTest {

    /**
     * Тестируем получение веса для мужчины.
     */
    @Test
    public void manWeight() {
        double in = 180;
        double expected = 92;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }

    /**
     * Тестируем получение веса для женщины.
     */
    @Test
    public void womanWeight() {
        double in = 150;
        double expected = 46;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}
