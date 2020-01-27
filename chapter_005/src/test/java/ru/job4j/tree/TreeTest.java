package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    private Tree<Integer> tree;

    @Before
    public void beforeTest() {
        tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
    }

    @Test
    public void when6ElFindLastThen6() {
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenElementExistsItShouldReturnFalse() {
        assertThat(tree.add(4, 2), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorForTreeShouldReturnAllValues() {
        Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorForTreeHasChangedShouldReturnCMException() {
        Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(tree.add(4, 8), is(true));
        iterator.hasNext();
    }

    @Test
    public void whenTreeIsNotBinaryShouldReturnFalse() {
        assertThat(tree.isBinary(), is(false));
    }
}

