package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест на класс CheckPrimeNumber.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class CheckPrimeNumberTest {

    /**
     * Тестируем число пять.
     */
    @Test
    public void when5() {
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        boolean result = checkPrimeNumber.check(5);
        assertThat(result, is(true));
    }

    /**
     * Тестируем число четыре.
     */
    @Test
    public void when4() {
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        boolean result = checkPrimeNumber.check(4);
        assertThat(result, is(false));
    }

    /**
     * Тестируем число один.
     */
    @Test
    public void when1() {
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        boolean rsl = checkPrimeNumber.check(1);
        assertThat(rsl, is(false));
    }
}
