package ru.job4j.buffer;

public class Buffer {
    private StringBuilder buffer = new StringBuilder();

    public void add(int value) {
        System.out.print(value);
        synchronized (this.buffer) {
            buffer.append(value);
        }
    }

    @Override
    public String toString() {
        synchronized (this.buffer) {
            return buffer.toString();
        }
    }
}
