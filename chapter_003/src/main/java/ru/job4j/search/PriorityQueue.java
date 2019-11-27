package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        var insert = 0;
        for (var t : tasks) {
            if (task.getPriority() < t.getPriority()) {
                insert = tasks.indexOf(t);
                break;
            }
        }
        tasks.add(insert, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}

