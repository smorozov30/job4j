package ru.job4j.sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс демонстрация компараторов.
 *
 * @author Sergey Morozov(moroz.future@gmail.com)
 * @version 1.0
 */
public class SortUser {

    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        return list.stream().sorted((Comparator.comparingInt(o -> o.getName().length()))).collect(Collectors.toList());
    }

    public List<User> sortByAllFields(List<User> list) {
        return list.stream().sorted((Comparator.comparingInt(User::getAge))).collect(Collectors.toList());
    }
}
