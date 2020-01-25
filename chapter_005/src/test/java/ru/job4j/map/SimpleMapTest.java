package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleMapTest {
    private SimpleMap<Integer, String> map = new SimpleMap<>();

    @Before
    public void beforeTest() {
        assertThat(this.map.insert(1, "one"), is(true));
        assertThat(this.map.insert(2, "two"), is(true));
        assertThat(this.map.insert(3, "three"), is(true));
        assertThat(this.map.insert(4, "four"), is(true));
        assertThat(this.map.insert(5, "five"), is(true));
    }

    @Test
    public void whenInsertExistingKeyShouldReturnFalse() {
        assertThat(this.map.insert(3, "THREE"), is(false));
    }

    @Test
    public void whenGetFiveKeysShouldReturnFiveValues() {
        assertThat(this.map.get(5), is("five"));
        assertThat(this.map.get(4), is("four"));
        assertThat(this.map.get(3), is("three"));
        assertThat(this.map.get(2), is("two"));
        assertThat(this.map.get(1), is("one"));
    }

    @Test
    public void whenDeleteTwoPairsShouldReturnTwoTrue() {
        assertThat(this.map.delete(2), is(true));
        assertThat(this.map.delete(4), is(true));
        assertThat(this.map.delete(2), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThrowNSEException() {
        Iterator<SimpleMap.Pair<Integer, String>> iterator = this.map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getKey(), is(1));
        assertThat(iterator.next().getKey(), is(2));
        assertThat(iterator.next().getKey(), is(3));
        assertThat(iterator.next().getKey(), is(4));
        assertThat(iterator.next().getKey(), is(5));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorThrowCMException() {
        Iterator<SimpleMap.Pair<Integer, String>> iterator = this.map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getKey(), is(1));
        assertThat(this.map.insert(6, "six"), is(true));
        iterator.next();
    }
}
