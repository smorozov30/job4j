package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест на класс EndsWith.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class EndsWithTest {

    /**
     * Тестируем создание экземпляра класса.
     */
    @Test
    public void whenCreateObject() {
        EndsWith endsWith = new EndsWith();
        assertNotNull(endsWith);
    }

    /**
     * Тестируем случай когда слово заканчивается на постфикс.
     */
    @Test
    public void whenEndsWithPostfixThenTrue() {
        char[] word = new char[]{'H', 'e', 'l', 'l', 'o'};
        char[] post = new char[] {'l', 'o'};
        boolean result = EndsWith.endsWith(word, post);
        assertThat(result, is(true));
    }

    /**
     * Тестируем случай когда слово НЕ заканчивается на постфикс.
     */
    @Test
    public void whenNotEndsWithPostfixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'a'};
        boolean result = EndsWith.endsWith(word, post);
        assertThat(result, is(false));
    }
}
