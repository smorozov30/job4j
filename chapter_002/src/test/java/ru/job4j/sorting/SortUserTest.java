package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {
    @Test
    public void sortMethodTest() {
        User first = new User("bob", 20);
        User second = new User("ira", 10);
        User third = new User("vas", 15);
        List<User> list = Arrays.asList(first, second, third);
        TreeSet<User> treeSet = (TreeSet<User>) new SortUser().sort(list);
        List<User> result = new ArrayList<>(treeSet);
        List<User> expected = Arrays.asList(second, third, first);
        assertThat(result, is(expected));
    }
    @Test
    public void sortNameLengthMethodTest() {
        User first = new User("sergei", 20);
        User second = new User("ivan", 10);
        User third = new User("vasya", 15);
        List<User> result = new SortUser().sortNameLength(Arrays.asList(first, second, third));
        List<User> expected = Arrays.asList(second, third, first);
        assertThat(result, is(expected));
    }
    @Test
    public void sortAllFieldsMethodTest() {
        User first = new User("sergei", 20);
        User second = new User("ivan", 10);
        User third = new User("sergei", 15);
        User fourth = new User("ivan", 12);
        List<User> result = new SortUser().sortByAllFields(Arrays.asList(first, second, third, fourth));
        List<User> expected = Arrays.asList(second, fourth, third, first);
        assertThat(result, is(expected));
    }
}
