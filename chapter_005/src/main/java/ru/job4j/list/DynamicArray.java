package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements Iterable<E> {
    private Object[] container;
    private int position = 0;
    private int modCount = 0;

    public DynamicArray() {
       this(0);
    }

    public DynamicArray(int size) {
        this.container = new Object[size];
    }

    public boolean add(E element) {
        if (this.position >= this.container.length) {
            Object[] temp = this.container.clone();
            this.container = new Object[this.container.length * 2 + 1];
            System.arraycopy(temp, 0, this.container, 0, temp.length);
        }
        this.container[position++] = element;
        this.modCount++;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= this.position) {
            throw new ArrayIndexOutOfBoundsException("Вышли за границы коллекции.");
        }
        return (E) this.container[index];
    }

    public int size() {
        return this.position;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Коллекция была изменена.");
                }
                return this.cursor < position;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[cursor++];
            }
        };
    }
}
