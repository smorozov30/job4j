package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс Matrix.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MatrixTest {

    /**
     * Теституем создание матрицы 2*2.
     */
    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expected = {{1, 2},
                            {2, 4}};
        assertThat(table, is(expected));
    }

    /**
     * Теституем создание матрицы 5*5.
     */
    @Test
    public void when5on5() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(5);
        int[][] expected = {{1, 2, 3, 4, 5},
                            {2, 4, 6, 8, 10},
                            {3, 6, 9, 12, 15},
                            {4, 8, 12, 16, 20},
                            {5, 10, 15, 20, 25}};
        assertThat(table, is(expected));
    }
}
