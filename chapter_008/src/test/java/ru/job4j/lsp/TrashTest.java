package ru.job4j.lsp;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class TrashTest {

    @Test
    public void checkProduct() {
        Trash trash = new Trash(100, 100);
        Milk milk = new Milk("milk", new GregorianCalendar(2020, Calendar.AUGUST, 30), new GregorianCalendar(2020, Calendar.JULY, 20), 100.0);
        Meat meat = new Meat("meat", new GregorianCalendar(2020, Calendar.AUGUST, 3), new GregorianCalendar(2020, Calendar.JULY, 13), 110.0);
        Bread bread = new Bread("bread", new GregorianCalendar(2020, Calendar.JULY, 26), new GregorianCalendar(2020, Calendar.JULY, 13), 120.0);
        Apple apple = new Apple("apple", new GregorianCalendar(2020, Calendar.JULY, 22), new GregorianCalendar(2020, Calendar.JULY, 20), 130.0);
        assertTrue(trash.checkProduct(meat));
<<<<<<< HEAD
        assertTrue(trash.checkProduct(milk));
=======
        assertFalse(trash.checkProduct(milk));
>>>>>>> design_lsp
        assertTrue(trash.checkProduct(bread));
        assertTrue(trash.checkProduct(apple));
    }
}