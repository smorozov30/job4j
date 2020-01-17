package ru.job4j.list;

import java.util.Iterator;

public class SimpleStack<T> implements Iterable<T> {
    private LinkedContainer<T> container = new LinkedContainer<>();

    public void push(T value) {
        this.container.add(value);
    }

    public T poll() {
        return this.container.delete();
    }

    public int size() {
        return this.container.size();
    }

    @Override
    public Iterator<T> iterator() {
        return this.container.iterator();
    }
}
