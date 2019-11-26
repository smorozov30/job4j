package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void whenEnterListGetMap() {
        Student first = new Student(10, "Morozov");
        Student second = new Student(10, "Ivanov");
        List<Student> students = Arrays.asList(first, second, first);
        Map<String, Student> result = new Converter().convert(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Morozov", first);
        expected.put("Ivanov", second);
        assertThat(result, is(expected));
    }
}
