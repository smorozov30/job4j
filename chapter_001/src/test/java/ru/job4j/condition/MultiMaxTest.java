package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс MultiMax.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MultiMaxTest {

    /**
     * Тестируем когда число на второй позиции самое большое.
     */
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    /**
     * Тестируем когда число на первой позиции самое большое.
     */
    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(5, 1, 2);
        assertThat(result, is(5));
    }

    /**
     * Тестируем когда число на третей позиции самое большое.
     */
    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 8);
        assertThat(result, is(8));
    }

    /**
     * Тестируем когда все числа равны.
     */
    @Test
    public void whenAllEquals() {
        MultiMax check = new MultiMax();
        int result = check.max(9, 9, 9);
        assertThat(result, is(9));
    }
}
