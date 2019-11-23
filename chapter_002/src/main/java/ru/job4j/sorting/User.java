package ru.job4j.sorting;

public class User implements Comparable {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        return ((this.age < ((User) o).age)) ? -1 : 1;
    }

    public String toString() {
        return String.format(getName() + " : " + getAge());
    }
}
