package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест на класс PrimeNumber.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class PrimeNumberTest {

    /**
     * Проверяем количество простых числе в диапазоне от 0 до 5.
     */
    @Test
    public void when5() {
        PrimeNumber primeNumber = new PrimeNumber();
        int count = primeNumber.calc(5);
        assertThat(count, is(3));
    }

    /**
     * Проверяем количество простых числе в диапазоне от 0 до 11.
     */
    @Test
    public void when11() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(11);
        assertThat(count, is(5));
    }

    /**
     * Проверяем количество простых числе в диапазоне от 0 до 2.
     */
    @Test
    public void when2() {
        PrimeNumber prime = new PrimeNumber();
        int count = prime.calc(2);
        assertThat(count, is(1));
    }
}
