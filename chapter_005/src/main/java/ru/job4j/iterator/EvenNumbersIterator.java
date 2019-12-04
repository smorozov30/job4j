package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] value;
    private int index = 0;

    public EvenNumbersIterator(final int[] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return search();
    }

    @Override
    public Integer next() {
        if (!search()) {
            throw new NoSuchElementException();
        }
        return value[index++];
    }

    private boolean search() {
        boolean result = false;
        for (int i = index; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                index = i;
                result = true;
                break;
            }
        }
        return result;
    }
}
