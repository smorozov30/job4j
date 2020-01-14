package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    private SimpleStack<Integer> numbers;
    @Before
    public void beforeTest() {
        numbers = new SimpleStack<>();
    }
    @Test
    public void whenPushThreeNumbersThenPollThreeNumbersBack() {
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);
        assertThat(numbers.poll(), is(3));
        assertThat(numbers.poll(), is(2));
        assertThat(numbers.poll(), is(1));
    }
}
