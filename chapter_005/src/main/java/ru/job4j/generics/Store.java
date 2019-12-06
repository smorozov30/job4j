package ru.job4j.generics;

public interface Store<T extends Base> {

    void add(T element);

    boolean replace(String id, T element);

    boolean delete(String id);

    T findById(String id);
}
