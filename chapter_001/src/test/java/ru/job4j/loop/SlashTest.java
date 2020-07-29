package ru.job4j.loop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Тест на класс Slash.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class SlashTest {

    /**
     * Переменная для замены стандартного потока вывода в консоль.
     */
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream printStream = System.out;

    /**
     * Тест выполняется перед остальными тестами для замены потока вывода.
     */
    @Before
    public void beforeTests() {
        System.setOut(new PrintStream(output));

    }

    /**
     * Тестируем создание экземпляра класса Slash.
     */
    @Test
    public void whenCreateObject() {
        Slash slash = new Slash();
        assertNotNull(slash);
    }

    /**
     * Тестируем вывод в консоль креста размером 3.
     */
    @Test
    public void whenDrawWithSize3() {
        String expected = "0 0"
                        + System.lineSeparator()
                        + " 0 "
                        + System.lineSeparator()
                        + "0 0"
                        + System.lineSeparator()
                        + System.lineSeparator();
        int size = 3;
        Slash.draw(size);
        assertEquals(expected, this.output.toString());
    }

    /**
     * Тестируем вывод в консоль креста размером 9.
     */
    @Test
    public void whenDrawWithSize9() {
        String expected = "0       0"
                        + System.lineSeparator()
                        + " 0     0 "
                        + System.lineSeparator()
                        + "  0   0  "
                        + System.lineSeparator()
                        + "   0 0   "
                        + System.lineSeparator()
                        + "    0    "
                        + System.lineSeparator()
                        +  "   0 0   "
                        + System.lineSeparator()
                        + "  0   0  "
                        + System.lineSeparator()
                        + " 0     0 "
                        + System.lineSeparator()
                        +  "0       0"
                        + System.lineSeparator()
                        + System.lineSeparator();
        int size = 9;
        Slash.draw(size);
        assertEquals(expected, this.output.toString());
    }

    /**
     * Тест выполняется после всех тестов для замены потока вывода.
     */
    @After
    public void afterTests() {
        System.setOut(printStream);
    }
}