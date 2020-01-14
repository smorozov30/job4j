package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    private SimpleQueue<Integer> numbers;
    @Before
    public void beforeTest() {
        numbers = new SimpleQueue<>();
    }
    @Test
    public void whenPushThreeNumbersThenPollThreeNumbers() {
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);
        assertThat(numbers.poll(), is(1));
        assertThat(numbers.poll(), is(2));
        assertThat(numbers.poll(), is(3));
        numbers.push(4);
        numbers.push(5);
        assertThat(numbers.poll(), is(4));
        assertThat(numbers.poll(), is(5));
    }
}
