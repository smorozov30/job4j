package ru.job4j.lsp;

import java.util.GregorianCalendar;

public class Milk extends Food {
    public Milk(String name, GregorianCalendar expireDate, GregorianCalendar createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
