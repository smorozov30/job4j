package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConverterMatrixTest {
    @Test
    public void whenEnterMatrixGetList() {
        List<Integer> first = List.of(10, 20, 30, 40, 50);
        List<Integer> second = List.of(60, 70, 80, 90);
        List<List<Integer>> matrix = List.of(first, second);
        List<Integer> result = new ConverterMatrix().convert(matrix);
        List<Integer> expected = List.of(10, 20, 30, 40, 50, 60, 70, 80, 90);
        assertThat(result, is(expected));
    }
}
