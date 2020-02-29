package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {
    protected List<Food> products = new ArrayList<>();

    public void addFood(Food food) {
        this.products.add(food);
    }

    public List<Food> getAllProducts() {
        return this.products;
    }
}
