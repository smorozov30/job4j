package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {
    private DynamicArray<Integer> numbers;

    @Before
    public void beforeTests() {
        numbers = new DynamicArray<>();
        this.numbers.add(1);
        this.numbers.add(2);
        this.numbers.add(3);
        this.numbers.add(4);
        this.numbers.add(5);
    }
    @Test
    public void whenAddFiveElementsThanReturnSizeFive() {
        int result = this.numbers.size();
        assertThat(result, is(5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetIndexTwoThanReturnNumberThree() {
        assertThat(this.numbers.get(0), is(1));
        assertThat(this.numbers.get(1), is(2));
        assertThat(this.numbers.get(2), is(3));
        assertThat(this.numbers.get(3), is(4));
        assertThat(this.numbers.get(4), is(5));
        this.numbers.get(5);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFiveTimeReturnTrue() {
        Iterator<Integer> iterator = this.numbers.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeCollectionShouldThrowException() {
        Iterator<Integer> iterator = this.numbers.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        this.numbers.add(10);
        iterator.next();
    }
}