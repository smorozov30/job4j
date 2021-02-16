package ru.job4j.pojo;

/**
 * Класс продукт.
 *
 * @author Sergey Morozov(moroz.future@gmail.com)
 * @version 1.0
 */
public class Product {
    private String name;
    private int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
