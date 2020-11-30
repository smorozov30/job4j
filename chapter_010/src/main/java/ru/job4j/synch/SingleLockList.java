package ru.job4j.synch;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynamicArray;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {

    @GuardedBy("this")
    private DynamicArray<T> array = new DynamicArray<>();

    public synchronized void add(T value) {
        this.array.add(value);
    }

    public synchronized T get(int index) {
        return this.array.get(index);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.array).iterator();
    }

    private synchronized DynamicArray<T> copy(DynamicArray<T> array) {
        DynamicArray<T> temp = new DynamicArray<>();
        array.forEach(temp::add);
        return temp;
    }
}