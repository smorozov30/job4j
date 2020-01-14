package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedContainer<E> implements Iterable<E> {
    private Node<E> container;
    private int modCount = 0;
    private int size = 0;

    public LinkedContainer() {
        this.container = new Node<>();
    }

    public void add(E element) {
        this.container.add(element);
        this.size++;
        this.modCount++;
    }

    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.container.get(index);
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private Node.Data<E> next = container.getFirst();

            @Override
            public boolean hasNext() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Коллекция была изменена.");
                }
                return this.next != null;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = this.next.data;
                this.next = this.next.next;
                return result;
            }
        };
    }

    private static class Node<E> {
        private Data<E> first;

        public void add(E data) {
            Data<E> newLink = new Data<>(data);
            newLink.next = this.first;
            this.first = newLink;
        }

        public E delete() {
            E deleted = this.first.data;
            this.first = this.first.next;
            return deleted;
        }

        public E get(int index) {
            Data<E> result = this.first;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            return result.data;
        }

        public Data<E> getFirst() {
            return this.first;
        }

        private static class Data<E> {
            E data;
            Data<E> next;

            Data(E data) {
                this.data = data;
            }
        }
    }

}
