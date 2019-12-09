package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    private SimpleArray<String> strings;
    private SimpleArray<Integer> numbers;
    private Iterator<String> stringIterator;
    private Iterator<Integer> integerIterator;

    @Before
    public void loadBeforeTest() {
        numbers = new SimpleArray<>(4);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        strings = new SimpleArray<>(4);
        strings.add("one");
        strings.add("two");
        strings.add("three");
        integerIterator = numbers.iterator();
        stringIterator = strings.iterator();
    }

    @Test
    public void whenAddNumbersReturnNumbers() {
        assertThat(numbers.get(0), is(1));
        assertThat(numbers.get(1), is(2));
        assertThat(numbers.get(2), is(3));
    }

    @Test
    public void whenAddStringsWordReturnWord() {
        assertThat(strings.get(0), is("one"));
        assertThat(strings.get(1), is("two"));
        assertThat(strings.get(2), is("three"));
    }

    @Test
    public void whenAddElement() {
        assertThat(numbers.add(9), is(true));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddFourthElementForSize4() {
        numbers.add(3);
        numbers.add(9);
    }

    @Test
    public void whenSetIndex1Number9ReturnTrue() {
        assertThat(numbers.set(1, 9), is(true));
    }

    @Test
    public void whenSetIndex1StringWorkReturnTrue() {
        assertThat(strings.set(1, "Work"), is(true));
    }

    @Test
    public void whenRemoveSecondStringReturnTrue() {
        assertThat(strings.remove(1), is(true));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenRemoveBeyondTheRangeReturnException() {
        strings.remove(4);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNumbersSequentially() {
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.next(), is(1));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.next(), is(2));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.next(), is(3));
        assertThat(integerIterator.hasNext(), is(false));
        integerIterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnStringsSequentially() {
        assertThat(stringIterator.hasNext(), is(true));
        assertThat(stringIterator.next(), is("one"));
        assertThat(stringIterator.hasNext(), is(true));
        assertThat(stringIterator.next(), is("two"));
        assertThat(stringIterator.hasNext(), is(true));
        assertThat(stringIterator.next(), is("three"));
        assertThat(stringIterator.hasNext(), is(false));
        stringIterator.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.next(), is(1));
        assertThat(integerIterator.next(), is(2));
        assertThat(integerIterator.next(), is(3));
    }
}
