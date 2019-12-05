package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorOfIterators {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            private Iterator<Integer> iterator = it.next();

            @Override
            public boolean hasNext() {
                boolean result = false;
                while (it.hasNext() || iterator.hasNext()) {
                    if (iterator.hasNext()) {
                        result = true;
                        break;
                    } else {
                        iterator = it.next();
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}
