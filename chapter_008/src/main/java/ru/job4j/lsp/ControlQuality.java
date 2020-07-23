package ru.job4j.lsp;

import java.util.List;

public class ControlQuality {
    private List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void distribution(List<Food> foods) {
        for (Food food : foods) {
            for (Storage storage : storages) {
                storage.addFood(food);
            }
        }
    }
}