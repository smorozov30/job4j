package ru.job4j.pattern;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    private static final int MAX_SIZE = 10;
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    public synchronized void offer(T value) throws InterruptedException {
        while (this.queue.size() == MAX_SIZE) {
            this.wait();
        }
        this.queue.offer(value);
        this.notifyAll();
    }

    public synchronized T poll() throws InterruptedException {
        while (this.isEmpty()) {
            this.wait();
        }
        T element = this.queue.poll();
        this.notifyAll();
        return element;
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}