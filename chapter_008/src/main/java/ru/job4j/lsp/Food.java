package ru.job4j.lsp;

import java.util.GregorianCalendar;

public abstract class Food {
    protected String name;
    protected GregorianCalendar expireDate;
    protected GregorianCalendar createDate;
    protected double price;
    protected double discount;

    public Food(String name, GregorianCalendar expireDate, GregorianCalendar createDate, double price) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public GregorianCalendar getExpireDate() {
        return this.expireDate;
    }

    public GregorianCalendar getCreateDate() {
        return this.createDate;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}