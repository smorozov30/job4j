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
        if (tasks.isEmpty()) {
            tasks.add(task);
        } else {
            for (int index = 0; index < tasks.size(); index++) {
                if (tasks.get(index).getPriority() > task.getPriority()) {
                    tasks.add(index, task);
                    break;
                } else {
                    tasks.add(task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}

