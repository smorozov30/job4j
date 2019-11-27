package ru.job4j.innovations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortStudent {
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted().takeWhile(
                student -> (student.getScope() > bound)).collect(Collectors.toList());
    }
}
