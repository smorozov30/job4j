package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест на класс Min.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MinTest {

    /**
     * Тестируем создание экземпляра класса.
     */
    @Test
    public void whenCreateObject() {
        Min min = new Min();
        assertNotNull(min);
    }

    /**
     * Тестируем случай когда первое число в массиве минимальное.
     */
    @Test
    public void whenFirstMin() {
        assertThat(Min.findMin(new int[]{0, 5, 10}), is(0));
    }

    /**
     * Тестируем случай когда последнее число в массиве минимальное.
     */
    @Test
    public void whenLastMin() {
        assertThat(Min.findMin(new int[]{10, 5, 3}), is(3));
    }

    /**
     * Тестируем случай когда любое число в массиве минимальное.
     */
    @Test
    public void whenMiddleMin() {
        assertThat(Min.findMin(new int[] {10, 2, 5}), is(2));
    }
}
