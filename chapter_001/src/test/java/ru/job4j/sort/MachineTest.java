package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс Machine.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MachineTest {

    /**
     * Тестируем случай, когда сумма денег и сумма покупки равны.
     */
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    /**
     * Тестируем случай, когда нужно выдать сдачу 10 и 5 рублей.
     */
    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }
}
