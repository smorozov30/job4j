package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int position = 0;

    @SuppressWarnings("unchecked")
    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public boolean add(T element) {
        if (position >= this.array.length) {
            throw new ArrayIndexOutOfBoundsException("Переполнение контейнера.");
        }
        this.array[position++] = element;
        return true;
    }

    public boolean set(int index, T element) {
        boolean result = false;
        if (index >= 0 && index < this.array.length) {
            this.array[index] = element;
            result = true;
        }
        return result;
    }

    public boolean remove(int index) {
        boolean result = false;
        if (index >= 0 && index < this.array.length && this.array[index] != null) {
            for ( ; index < this.array.length - 1; index++) {
                this.array[index] = this.array[index + 1];
            }
            this.array[index] = null;
            this.position--;
            result = true;
        }
        return result;
    }

    public T get(int index) {
        if (index < 0 && index >= this.array.length) {
            throw new ArrayIndexOutOfBoundsException("Вышли за границы контейнера.");
        }
        return this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int positionIterator = 0;

            @Override
            public boolean hasNext() {
                 return positionIterator < array.length && array[positionIterator] != null;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[positionIterator++];
            }
        };
    }
}
