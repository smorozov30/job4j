package ru.job4j.lsp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class WarehouseTest {

    @Test
    public void checkProduct() {
        Warehouse warehouse = new Warehouse(0, 25);
        Milk milk = new Milk("milk", new GregorianCalendar(2020, Calendar.AUGUST, 30), new GregorianCalendar(2020, Calendar.JULY, 20), 100.0);
        Meat meat = new Meat("meat", new GregorianCalendar(2020, Calendar.AUGUST, 3), new GregorianCalendar(2020, Calendar.JULY, 13), 110.0);
        Bread bread = new Bread("bread", new GregorianCalendar(2020, Calendar.JULY, 26), new GregorianCalendar(2020, Calendar.JULY, 13), 120.0);
        Apple apple = new Apple("apple", new GregorianCalendar(2020, Calendar.JULY, 22), new GregorianCalendar(2020, Calendar.JULY, 20), 130.0);
        assertFalse(warehouse.checkProduct(meat));
        assertTrue(warehouse.checkProduct(milk));
        assertFalse(warehouse.checkProduct(bread));
        assertFalse(warehouse.checkProduct(apple));
    }
}