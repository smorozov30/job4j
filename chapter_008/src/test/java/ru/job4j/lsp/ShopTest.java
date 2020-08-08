package ru.job4j.lsp;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void checkProduct() {
        Shop shop = new Shop(25, 100);
        Milk milk = new Milk("milk", new GregorianCalendar(2020, Calendar.AUGUST, 30), new GregorianCalendar(2020, Calendar.JULY, 20), 100.0);
        Meat meat = new Meat("meat", new GregorianCalendar(2020, Calendar.AUGUST, 3), new GregorianCalendar(2020, Calendar.JULY, 13), 110.0);
        Bread bread = new Bread("bread", new GregorianCalendar(2020, Calendar.JULY, 26), new GregorianCalendar(2020, Calendar.JULY, 13), 120.0);
        Apple apple = new Apple("apple", new GregorianCalendar(2020, Calendar.JULY, 22), new GregorianCalendar(2020, Calendar.JULY, 20), 130.0);
        assertTrue(shop.checkProduct(milk));
        assertFalse(shop.checkProduct(meat));
        assertThat(meat.getDiscount(), is(50.0));
        assertFalse(shop.checkProduct(bread));
        assertThat(bread.getDiscount(), is(50.0));
        assertFalse(shop.checkProduct(apple));

    }
}