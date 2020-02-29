package ru.job4j.lsp;

import java.util.GregorianCalendar;

public class Apple extends Food {
    public Apple(String name, GregorianCalendar expireDate, GregorianCalendar createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
