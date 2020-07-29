package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест на класс MinDiapason.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MinDiapasonTest {

    /**
     * Тестируем случай когда минимальное число под индексом 1.
     */
    @Test
    public void whenFirstMin() {
        assertThat(MinDiapason.findMin(new int[]{-1, 0, 5, 10}, 1, 3), is(0));
    }

    /**
     * Тестируем случай когда минимальное число под индексом 3.
     */
    @Test
    public void whenLastMin() {
        assertThat(MinDiapason.findMin(new int[] {10, 5, 3, 1}, 1, 3), is(1));
    }

    /**
     * Тестируем случай когда минимальное число под индексом 1.
     */
    @Test
    public void whenMiddleMin() {
        assertThat(MinDiapason.findMin(new int[] {10, 2, 5, 1}, 0, 2), is(2));
    }
}
