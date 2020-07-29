package ru.job4j.loop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Тест на класс Board.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class BoardTest {

    /**
     * Собственный поток для замены стандартного вывода в консоль.
     */
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream printStream = System.out;


    /**
     * Тест выполняется перед остальными тестами для замены потока вывода.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    /**
     * Тестируем создание экземпляра класса Board.
     */
    @Test
    public void whenCreateObject() {
        Board board = new Board();
        assertNotNull(board);
    }

    /**
     * Тестируем вывод в консоль шахматной доски 3*3.
     */
    @Test
    public void whenPaintBoard3X3() {
        String expected = "X X"
                        + System.lineSeparator()
                        + " X "
                        + System.lineSeparator()
                        + "X X"
                        + System.lineSeparator();
        Board.paint(3, 3);
        assertEquals(expected, this.output.toString());
    }

    /**
     * Тестируем вывод в консоль шахматной доски 5*4.
     */
    @Test
    public void whenPaintBoard5X4() {
        String expected = "X X X"
                        + System.lineSeparator()
                        + " X X "
                        + System.lineSeparator()
                        +  "X X X"
                        + System.lineSeparator()
                        + " X X "
                        + System.lineSeparator();
        Board.paint(5, 4);
        assertEquals(expected, this.output.toString());
    }

    /**
     * Тест выполняется после всех тестов для замены потока вывода.
     */
    @After
    public void cleanUpStreams() {
        System.setOut(printStream);
    }
}