package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CountTest {
    @Test
    public void whenEnterListGetSum100() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int result = new Count().count(numbers);
        assertThat(result, is(120));
    }
}
