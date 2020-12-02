package ru.job4j.atomic;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count = new AtomicReference<>(0);

    public void increment() {
        Integer ref;
        do {
            ref = this.count.get();
        } while (!this.count.compareAndSet(ref, ref + 1));
    }

    public int get() {
        return this.count.get();
    }
}