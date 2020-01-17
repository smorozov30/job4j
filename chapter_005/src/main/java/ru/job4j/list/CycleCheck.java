package ru.job4j.list;

public class CycleCheck {
    public boolean hasCycle(Node first) {
        Node tortoise = first;
        Node hare = first.next;
        boolean result = false;
        while (hare != null && hare.next != null) {
            if (hare == tortoise) {
                result = true;
                break;
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return result;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
