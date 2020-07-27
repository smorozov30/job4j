package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тест на класс Converter.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class ConverterTest {

    /**
     * Тестируем перевод рублей в евро.
     */
    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    /**
     * Тестируем перевод рублей в доллары.
     */
    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    /**
     * Тестируем перевод евро в рубли.
     */
    @Test
    public void euroToRuble() {
        int in = 3;
        int expected = 210;
        int out = Converter.euroToRuble(in);
        Assert.assertEquals(expected, out);
    }

    /**
     * Тестируем перевод доллары в рубли.
     */
    @Test
    public void dollarToRuble() {
        int in = 10;
        int expected = 600;
        int out = Converter.dollarToRuble(in);
        Assert.assertEquals(expected, out);
    }
}
