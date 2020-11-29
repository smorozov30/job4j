package ru.job4j.concurrent;

public class Count {
    private int value;

    public synchronized void increment() {
        value++;
    }

    public int get() {
        return value;
    }
}
