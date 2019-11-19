package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                4
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void convertMethod() {
        ConvertList2Array convertList = new ConvertList2Array();
        List<int[]> listArrays = new ArrayList<>();
        listArrays.add(new int[]{1, 2});
        listArrays.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(listArrays);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
