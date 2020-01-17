package ru.job4j.set;

import ru.job4j.list.DynamicArray;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private DynamicArray<E> container = new DynamicArray();

    public boolean add(E value) {
        return !checkDuplicate(value) && this.container.add(value);
    }

    private boolean checkDuplicate(E value) {
        boolean result = false;
        for (E e : this.container) {
            if (value.equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}
