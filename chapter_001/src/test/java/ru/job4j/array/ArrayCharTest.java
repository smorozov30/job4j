package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест на класс ArrayChar.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class ArrayCharTest {

    /**
     * Тестируем создание экземпляра класса.
     */
    @Test
    public void whenCreateObject() {
        ArrayChar arrayChar = new ArrayChar();
        assertNotNull(arrayChar);
    }

    /**
     * Тестируем случай когда слово начинается с префикса.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        char[] word = new char[]{'H', 'e', 'l', 'l', 'o'};
        char[] pref = new char[]{'H', 'e'};
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(true));
    }

    /**
     * Тестируем случай когда слово НЕ начинается с префикса.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'i'};
        boolean result = ArrayChar.startsWith(word, pref);
        assertThat(result, is(false));
    }
}
