package ru.job4j.list;

public class SimpleStack<T> {
    private LinkedContainer<T> container = new LinkedContainer<>();

    public void push(T value) {
        this.container.add(value);
    }

    public T poll() {
        return this.container.delete();
    }
}
