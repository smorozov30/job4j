package ru.job4j.lsp;

import java.util.GregorianCalendar;

public class Meat extends Food {
    public Meat(String name, GregorianCalendar expireDate, GregorianCalendar createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
