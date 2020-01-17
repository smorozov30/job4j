package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack<T> first = new SimpleStack<>();
    private SimpleStack<T> reverse = new SimpleStack<>();;

    public T poll() {
        this.pass(this.first, this.reverse);
        return reverse.poll();
    }
    public void push(T value) {
        this.pass(this.reverse, this.first);
        this.first.push(value);
    }
    private void pass(SimpleStack<T> first, SimpleStack<T> second) {
        while (first.size() > 0) {
            second.push(first.poll());
        }
    }
}
