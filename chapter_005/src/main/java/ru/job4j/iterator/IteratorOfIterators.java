package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorOfIterators {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            private Iterator<Integer> iterator = it.next();

            @Override
            public boolean hasNext() {
                return this.check();
            }

            @Override
            public Integer next() {
                if (!check()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }

            private boolean check() {
                boolean result = false;
                if (iterator.hasNext()) {
                    result = true;
                } else if (it.hasNext()) {
                    iterator = it.next();
                    result = iterator.hasNext();
                }
                return result;
            }
        };
    }
}
