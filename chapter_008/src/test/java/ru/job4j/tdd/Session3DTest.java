package ru.job4j.tdd;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Тест на класс Session3D.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Session3DTest {

    /**
     * Тестируем получение названия сеанса.
     */
    @Test
    public void title() {
        Session session = new Session3D("");
        assertThat(session.getTitle(), is(""));
    }
}