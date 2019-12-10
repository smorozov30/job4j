package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicLinkedArray<E> implements Iterable<E> {
    private int size;
    private int modCount;
    private Node<E> head;
    private Node<E> tail;

    public boolean add(E element) {
        Node<E> newLink = new Node<>(element);
        if (this.size == 0) {
            this.head = newLink;
        } else if (this.size == 1) {
            this.head.next = newLink;
            newLink.previous = this.head;
            this.tail = newLink;
        } else {
            this.tail.next = newLink;
            newLink.previous = this.tail;
            this.tail = newLink;
        }
        this.size++;
        this.modCount++;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Вышли за границы коллекции.");
        }
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return this.size;
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
                return this.cursor < size;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> current = head;
                for (int i = 0; i < cursor; i++) {
                    current = current.next;
                }
                this.cursor++;
                return current.data;
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        Node(E data) {
            this.data = data;
        }
    }
}
