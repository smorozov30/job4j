package ru.job4j.lsp;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ControlQualityTest {
    @Test
    public void whenRemoveProducts() {
        Milk milk = new Milk("milk", new GregorianCalendar(2020, Calendar.AUGUST, 30), new GregorianCalendar(2020, Calendar.JULY, 20), 100.0);
        Meat meat = new Meat("meat", new GregorianCalendar(2020, Calendar.AUGUST, 3), new GregorianCalendar(2020, Calendar.JULY, 13), 110.0);
        Bread bread = new Bread("bread", new GregorianCalendar(2020, Calendar.JULY, 26), new GregorianCalendar(2020, Calendar.JULY, 13), 120.0);
        Apple apple = new Apple("apple", new GregorianCalendar(2020, Calendar.JULY, 22), new GregorianCalendar(2020, Calendar.JULY, 20), 130.0);
        List<Food> foods = Arrays.asList(milk, bread, meat, apple);
        Warehouse warehouse = new Warehouse(0, 25);
        Shop shop = new Shop(25, 100);
        Trash trash = new Trash(100, 100);
        List<Storage> storages = Arrays.asList(warehouse, shop, trash);
        ControlQuality cq = new ControlQuality(storages);
        cq.distribution(foods);
        assertThat(warehouse.getAllProducts().size(), is(0));
        assertThat(shop.getAllProducts().size(), is(1));
        assertThat(trash.getAllProducts().size(), is(3));
    }
}
