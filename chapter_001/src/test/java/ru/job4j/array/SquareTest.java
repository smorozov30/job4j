package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс Square.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class SquareTest {

    /**
     * Тестируем заполнение масиива размером 3.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = new int[]{1, 4, 9};
        assertThat(rst, is(expected));
    }

    /**
     * Тестируем заполнение масиива размером 3.
     */
    @Test
    public void whenBound5Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = new int[]{1, 4, 9, 16, 25};
        assertThat(rst, is(expected));
    }

    /**
     * Тестируем заполнение масиива размером 3.
     */
    @Test
    public void whenBound7Then14916253649() {
        int bound = 7;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = new int[]{1, 4, 9, 16, 25, 36, 49};
        assertThat(rst, is(expected));
    }
}
