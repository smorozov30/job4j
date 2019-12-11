package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedContainerTest {
    private  LinkedContainer<Integer> container;

    @Before
    public void beforeTests() {
        this.container = new LinkedContainer<>();
        this.container.add(1);
        this.container.add(2);
        this.container.add(3);
    }

    @Test
    public void whenAddThreeElementsReturnSizeThree() {
        assertThat(this.container.size(), is(3));
    }

    @Test
    public void whenGetFirstElementReturnThree() {
        assertThat(container.get(0), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetOverElementsThanReturnException() {
        assertThat(this.container.get(0), is(3));
        assertThat(this.container.get(1), is(2));
        assertThat(this.container.get(2), is(1));
        this.container.get(3);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldInTheEndReturnFalseAndThrowException() {
        Iterator<Integer> iterator = this.container.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

}
