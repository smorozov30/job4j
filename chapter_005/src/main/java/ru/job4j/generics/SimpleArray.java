package ru.job4j.generics;

import java.util.ArrayList;
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
        this.checkIndex(index);
        this.array[index] = element;
        return true;
    }

    public boolean remove(int index) {
        this.checkIndex(index);
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        return true;
    }

    public T get(int index) {
        this.checkIndex(index);
        return this.array[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.position) {
            throw new ArrayIndexOutOfBoundsException("Вышли за границы контейнера.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int positionIterator = 0;

            @Override
            public boolean hasNext() {
                 return this.positionIterator < position;
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
    ArrayList<String> test = new ArrayList<>();
}
