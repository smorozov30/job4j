package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public enum TrackerOne {
    INSTANCE;

    private Item item;

    public Item add(Item model) {
        if (item == null) {
            item = model;
        }
        return item;
    }
}
