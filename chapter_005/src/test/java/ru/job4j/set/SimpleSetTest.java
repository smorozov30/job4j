package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test (expected = NoSuchElementException.class)
    public void whenAddDuplicate() {
        SimpleSet<Integer> set = new SimpleSet<>();
        assertThat(set.add(1), is(true));
        assertThat(set.add(2), is(true));
        assertThat(set.add(3), is(true));
        assertThat(set.add(1), is(false));
        assertThat(set.add(5), is(true));
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
}
