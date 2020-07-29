package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тест на класс DummyDic.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class DummyDicTest {

    /**
     * Тестируем вывод неизвестного слова.
     */
    @Test
    public void engToRus() {
        DummyDic dummyDic = new DummyDic();
        String result = dummyDic.engToRus("hello");
        String expected = "Неизвестное слово.hello";
        assertEquals(expected, result);
    }
}