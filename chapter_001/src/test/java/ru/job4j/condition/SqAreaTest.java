package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест на класс SqArea.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class SqAreaTest {

    /**
     * Тестируем создание экземпляра класса SqArea.
     */
    @Test
    public void createClass() {
        SqArea sqArea = new SqArea();
        assertNotNull(sqArea);
    }

    /**
     * Тест с периметром 4 и коэфициентом 1.
     */
    @Test
    public void whenp4k1s1() {
        int k = 1;
        int p = 4;
        int expected = 1;
        int s = SqArea.square(p, k);
        assertThat(s, is(expected));
    }

    /**
     * Тест с периметром 6 и коэфициентом 2.
     */
    @Test
    public void whenp6k2s2() {
        int k = 2;
        int p = 6;
        int expected = 2;
        int s = SqArea.square(p, k);
        assertThat(s, is(expected));
    }
}
