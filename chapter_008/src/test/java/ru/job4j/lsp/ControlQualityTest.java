package ru.job4j.lsp;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class ControlQualityTest {
    @Test
    public void whenRemoveProducts() {
        Milk milk = new Milk("milk", new GregorianCalendar(2020, 2, 30), new GregorianCalendar(2020, 1, 27), 100.0);
        Meat meat = new Meat("meat", new GregorianCalendar(2020, 2, 30), new GregorianCalendar(2020, 1, 15), 110.0);
        Bread bread = new Bread("bread", new GregorianCalendar(2020, 2, 10), new GregorianCalendar(2020, 0, 1), 120.0);
        Apple apple = new Apple("apple", new GregorianCalendar(2020, 1, 28), new GregorianCalendar(2020, 1, 25), 130.0);
        List<Food> foods = Arrays.asList(milk, bread, meat, apple);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> list = Arrays.asList(warehouse, shop, trash);
        ControlQuality cq = new ControlQuality(warehouse, shop, trash);
        cq.controlDate(foods);
        assertThat(warehouse.getAllProducts().size(), is(1));
        assertThat(shop.getAllProducts().size(), is(2));
        assertThat(trash.getAllProducts().size(), is(1));
    }
}
