package ru.job4j.innovations;

public class Student implements Comparable<Student> {
    private int scope;
    private String surname;

    public Student(int scope) {
        this.scope = scope;
    }

    public Student(int scope, String surname) {
        this.scope = scope;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.getScope(), this.scope);
    }
}
