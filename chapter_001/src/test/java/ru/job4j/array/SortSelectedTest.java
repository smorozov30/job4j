package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс SortSelected.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class SortSelectedTest {

    /**
     * Тестируем создание экземпляра класса.
     */
    @Test
    public void whenCreateObject() {
        SortSelected sortSelected = new SortSelected();
        assertNotNull(sortSelected);
    }

    /**
     * Тестируем сортировку массива из пяти чисел.
     */
    @Test
    public void whenSortLength5() {
        int[] input = new int[]{3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expected = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expected));
    }

    /**
     * Тестируем сортировку массива из пяти чисел.
     */
    @Test
    public void whenSortLength3() {
        int[] input = new int[]{12, 3, 7};
        int[] result = SortSelected.sort(input);
        int[] expected = new int[]{3, 7, 12};
        assertThat(result, is(expected));
    }
}
