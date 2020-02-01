package ru.job4j.tree;

import ru.job4j.list.SimpleQueue;
import ru.job4j.list.SimpleStack;

import java.util.*;

/**
 * @author Sergey Morozov (sergey.se1ove.morozov@gmail.com)
 * @param <E>
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount = 0;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    /**
     * Метод добавляет элементу дерева дочерний элемент(образуется новая ветка).
     * Проверяет существует ли родительский элемент(должен существовать).
     * Проверяет существует ли дочерний элемент(не должен существовать).
     * Добавляет/Не добавляет элемент в дерево.
     * @param parent - элемент которому добавляется дочерний элемент.
     * @param child - элемент который нужно добавить.
     * @return - результат добавления элемента:
     *          (true - если родительский элемент существует, а дочерний отсутствует в дереве,
     *          false - если родительский элемент не существует, или дочерний уже присутствует в дереве).
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> foundParent = this.findBy(parent);
        Optional<Node<E>> foundChild = this.findBy(child);
        if (foundParent.isPresent() && foundChild.isEmpty()) {
            foundParent.get().add(new Node<>(child));
            this.modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Метод проходит по каждому элементу дерева, и проверяет количество дочерних элементов.
     * Дерево считается бинарным, если у каждого элемента дерева не больше двух дочерних.
     * @return - результат проверки.
     */
    public boolean isBinary() {
        boolean result = true;
        SimpleQueue<Node<E>> stack = new SimpleQueue<>();
        stack.push(this.root);
        while (stack.size() > 0) {
            List<Node<E>> children = stack.poll().leaves();
            if (children.size() > 2) {
                result = false;
                break;
            }
            for (Node<E> child : children) {
                stack.push(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            SimpleQueue<Node<E>> stack = new SimpleQueue<>();
            private boolean stackIsEmpty = true;

            @Override
            public boolean hasNext() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (this.stackIsEmpty) {
                    this.stack.push(root);
                    this.stackIsEmpty = false;
                }
                return this.stack.size() > 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> element = stack.poll();
                List<Node<E>> children = element.leaves();
                for (Node<E> child : children) {
                    this.stack.push(child);
                }
                return element.getValue();
            }
        };
    }
}
