package ru.job4j.innovations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortStudent {
    public List<Student> levelOf(List<Student> students, int bound) {
        List<Student> withoutNull = students.stream().flatMap(Stream::ofNullable).sorted().collect(Collectors.toList());
        List<Student> result = withoutNull.stream().takeWhile(student -> (student.getScope() > bound)).collect(Collectors.toList());
        return result;
    }
}
