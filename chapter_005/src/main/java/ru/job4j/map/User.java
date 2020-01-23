package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User first = new User("Sergey", 3, new GregorianCalendar(1990, 9, 31));
        User second = new User("Sergey", 3, new GregorianCalendar(1990, 9, 31));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "firstValue");
        map.put(second, "secondValue");
        System.out.println(map);
    }
}
