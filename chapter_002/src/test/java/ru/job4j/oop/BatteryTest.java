package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тест на класс Battery.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class BatteryTest {

    /**
     * Тестируем перезарядку из одной батареи в другую.
     */
    @Test
    public void exchange() {
        Battery first = new Battery(5);
        Battery second = new Battery(15);
        first.exchange(second);
        int expected = 20;
        int result = second.getLoad();
        assertEquals(expected, result);
    }
}