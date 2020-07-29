package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Тест на класс Defragment.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class DefragmentTest {

    /**
     * Тестируем создание экземпляра классаю
     */
    @Test
    public void whenOnCreateObject() {
        Defragment defragment = new Defragment();
        assertNotNull(defragment);
    }

    /**
     * Тестируем массив с НЕ пустым первым элементом.
     */
    @Test
    public void notFirstNull() {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = Defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertThat(compressed, is(expected));
    }

    /**
     * Тестируем массив с пустым первым элементом.
     */
    @Test
    public void firstNull() {
        String[] input = {null, "I", "wanna", null, "be", null, "compressed"};
        String[] compressed = Defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertThat(compressed, is(expected));
    }

    /**
     * Тестируем массив с единственным не пустым значением.
     */
    @Test
    public void singleFirstNull() {
        String[] input = {null, "I"};
        String[] compressed = Defragment.compress(input);
        String[] expected = {"I", null};
        assertThat(compressed, is(expected));
    }

    /**
     * Тестируем массив со всеми пустыми значениями.
     */
    @Test
    public void notAllNull() {
        String[] input = {null, null, null};
        String[] compressed = Defragment.compress(input);
        String[] expected = {null, null, null};
        assertThat(compressed, is(expected));
    }

    /**
     * Тестируем уже дефрагментированный массив.
     */
    @Test
    public void notAllAtFirstNull() {
        String[] input = {null, null, null, "I", "wanna", "be", "compressed"};
        String[] compressed = Defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertThat(compressed, is(expected));
    }
}
