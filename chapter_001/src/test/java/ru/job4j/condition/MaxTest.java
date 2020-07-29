package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс Max.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MaxTest {

    /**
     * Тестируем создание экземпляра класса Max.
     */
    @Test
    public void createClass() {
        Max max = new Max();
        assertNotNull(max);
    }

    /**
     * Тестируем метод с двумя параметрами.
     */
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тестируем метод с тремя параметрами.
     */
    @Test
    public void whenMax3To2Then3() {
        int result = Max.max(3, 2, 1);
        assertThat(result, is(3));
    }

    /**
     * Тестируем метод с четырьмя параметрами.
     */
    @Test
    public void whenMax5To5Then5() {
        int result = Max.max(3, 2, 4, 1);
        assertThat(result, is(4));
    }
}
