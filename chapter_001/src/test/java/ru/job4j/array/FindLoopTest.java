package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс FindLoop.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class FindLoopTest {

    /**
     * Тестируем поиск индекса числа 2 в дипазоне массива.
     */
    @Test
    public void whenFind3() {
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    /**
     * Тестируем поиск индекса числа 1 в дипазоне массива.
     */
    @Test
    public void whenNotFind() {
        int[] input = new int[] {5, 2, 10, 6, 4};
        int value = 1;
        int start = 1;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    /**
     * Тестируем поиск индекса числа 5 массиве, когда элемент найден.
     */
    @Test
    public void whenArrayHas5Then0() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = findLoop.indexOf(input, value);
        int expected = 0;
        assertThat(result, is(expected));
    }

    /**
     * Тестируем поиск индекса числа 5 массиве, когда элемент не найден.
     */
    @Test
    public void whenArrayHasnt5ThenMinus1() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{4, 7, 9};
        int value = 5;
        int result = findLoop.indexOf(input, value);
        int expected = -1;
        assertThat(result, is(expected));
    }
}
