package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {

    protected double percentShelfLifeMin;
    protected double percentShelfLifeMax;
    protected List<Food> products = new ArrayList<>();

    protected Storage(double percentShelfLifeMin, double percentShelfLifeMax) {
        this.percentShelfLifeMin = percentShelfLifeMin;
        this.percentShelfLifeMax = percentShelfLifeMax;
    }

    public boolean addFood(Food food) {
        boolean result = this.checkProduct(food);
        if (result) {
            this.products.add(food);
        }
        return result;
    }

    public List<Food> getAllProducts() {
        return this.products;
    }

    protected abstract boolean checkProduct(Food food);

}
