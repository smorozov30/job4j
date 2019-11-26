package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    private List<Student> students;
    private School school;
    @Before
    public void initBeforeTests() {
         students = Arrays.asList(new Student(10), new Student(20), new Student(30),
                new Student(40), new Student(50), new Student(60),
                new Student(70), new Student(80), new Student(90),
                new Student(100));
         school = new School();
    }
    @Test
    public void whenFilterFrom0To50() {
        List<Student> list = school.collect(students, student -> (student.getScope() > 0 && student.getScope() < 50));
        int result = list.size();
        assertThat(result, is(4));
    }
    @Test
    public void whenFilterFrom50To70() {
        List<Student> list = school.collect(students, student -> (student.getScope() >= 50 && student.getScope() < 70));
        int result = list.size();
        assertThat(result, is(2));
    }
    @Test
    public void whenFilterFrom70To100() {
        List<Student> list = school.collect(students, student -> (student.getScope() >= 70 && student.getScope() <= 100));
        int result = list.size();
        assertThat(result, is(4));
    }
}
