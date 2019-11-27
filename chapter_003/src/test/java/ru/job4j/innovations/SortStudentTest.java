package ru.job4j.innovations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortStudentTest {
    @Test
    public void whenSortStudents() {
        Student first = new Student(80);
        Student second = new Student(50);
        Student third = new Student(90);
        Student fourth = new Student(30);
        List<Student> students = Arrays.asList(first, null, second, null, third, null, fourth);
        List<Student> result = new SortStudent().levelOf(students, 60);
        List<Student> expected = List.of(third, first);
        assertThat(result, is(expected));
    }
}
