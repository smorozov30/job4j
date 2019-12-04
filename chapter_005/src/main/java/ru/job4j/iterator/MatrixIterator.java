package ru.job4j.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator {
    private final int[][] values;
    private int row = 0;
    private int cell = 0;

    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result;
        if (values[row].length > cell) {
            result = true;
        } else {
            row++;
            cell = 0;
            result = row < values.length && this.hasNext();
        }
        return result;
    }

    @Override
    public Object next() {
        return this.hasNext() ? values[row][cell++] : -1;
    }
}
