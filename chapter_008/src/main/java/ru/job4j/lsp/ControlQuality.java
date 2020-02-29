package ru.job4j.lsp;

import java.util.List;

public class ControlQuality {
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    public ControlQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void controlDate(List<Food> foods) {
        for (Food food : foods) {
            Storage tempStorage = null;
            double shelfLife = this.getShelfLife(food);
            if (shelfLife >= 0 && shelfLife < 25) {
                tempStorage = warehouse;
            } else if (shelfLife >= 25 && shelfLife < 75) {
                tempStorage = shop;
            } else if (shelfLife >= 75 && shelfLife < 100) {
                food.setDiscount(food.price / 50);
                tempStorage = shop;
            } else {
                tempStorage = trash;
            }
            this.removeProduct(tempStorage, food);
        }
    }

    public void removeProduct(Storage to, Food food) {
        to.addFood(food);
    }

    public double getShelfLife(Food food) {
        long all = food.expireDate.getTimeInMillis() - food.createDate.getTimeInMillis();
        long now = System.currentTimeMillis() - food.createDate.getTimeInMillis();
        return ((double) now / all) * 100;
    }
}