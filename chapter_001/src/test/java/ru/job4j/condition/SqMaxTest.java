package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест на класс SqMax.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class SqMaxTest {

    /**
     * Тестируем создание экземпляра класса SqMax.
     */
    @Test
    public void whenCreateObject() {
        SqMax sqMax = new SqMax();
        assertNotNull(sqMax);
    }

    /**
     * Тестируем когда из четырех - первое число самое большое .
     */
    @Test
    public void whenFirstMax() {
        int result = SqMax.max(5, 3, 2, 1);
        assertThat(result, is(5));
    }

    /**
     * Тестируем когда из четырех - третье число самое большое .
     */
    @Test
    public void whenFirstOrThirdMax() {
        int result = SqMax.max(10, 19, 22, 1);
        assertThat(result, is(22));
    }

    /**
     * Тестируем когда из четырех - второе число самое большое .
     */
    @Test
    public void whenSecondMax() {
        int result = SqMax.max(5, 7, 1, 2);
        assertThat(result, is(7));
    }

    /**
     * Тестируем когда из четырех - третье число самое большое .
     */
    @Test
    public void whenThirdMax() {
        int result = SqMax.max(10, 7, 12, 2);
        assertThat(result, is(12));
    }

    /**
     * Тестируем когда из четырех - четвертое число самое большое .
     */
    @Test
    public void whenFourthMax() {
        int result = SqMax.max(10, 7, 12, 33);
        assertThat(result, is(33));
    }
}
