package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс Turn.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class TurnTest {

    /**
     * Тестируем случай когда нужно перевернуть массив с четным числом элементов.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expected = new int[]{2, 6, 1, 4};
        assertThat(result, is(expected));
    }

    /**
     * Тестируем случай когда нужно перевернуть массив с нечетным числом элементов.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2, 5};
        int[] result = turner.back(input);
        int[] expected = new int[]{5, 2, 6, 1, 4};
        assertThat(result, is(expected));
    }
}
