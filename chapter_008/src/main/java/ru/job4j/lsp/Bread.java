package ru.job4j.lsp;

import java.util.GregorianCalendar;

public class Bread extends Food {
    public Bread(String name, GregorianCalendar expireDate, GregorianCalendar createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
