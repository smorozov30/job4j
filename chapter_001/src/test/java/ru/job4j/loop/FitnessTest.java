package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест на класс Fitness.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class FitnessTest {

    /**
     * Тестируем условие когда первый изначально сильнее второго.
     */
    @Test
    public void whenIvanGreatNik() {
        Fitness fitness = new Fitness();
        int month = fitness.calc(95, 90);
        assertThat(month, is(0));
    }

    /**
     * Тестируем условие когда первый изначально слабее второго.
     */
    @Test
    public void whenIvanLessNik() {
        Fitness fitness = new Fitness();
        int month = fitness.calc(90, 95);
        assertThat(month, is(1));
    }

    /**
     * Тестируем условие когда первый изначально слабее второго.
     */
    @Test
    public void whenIvanLessByFewNik() {
        Fitness fit = new Fitness();
        int month = fit.calc(50, 90);
        assertThat(month, is(2));
    }
}
