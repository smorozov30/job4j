package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack<T> first = new SimpleStack<>();
    private SimpleStack<T> back;

    public T poll() {
        back = new SimpleStack<>();
        for (T t : this.first) {
            this.back.push(t);
        }
        T result = back.poll();
        first = new SimpleStack<>();
        for (T t : this.back) {
            this.first.push(t);
        }
        return result;
    }
    public void push(T value) {
        this.first.push(value);
    }
}
