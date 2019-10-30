package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {
    @Test
    public void whenSortLength5() {
        int[] input = new int[]{3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expected = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortLength3() {
        int[] input = new int[]{12, 3, 7};
        int[] result = SortSelected.sort(input);
        int[] expected = new int[]{3, 7, 12};
        assertThat(result, is(expected));
    }
}
