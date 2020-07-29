package ru.job4j.oop;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Тест на класс Cat.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class CatTest {

    /**
     * Переменная хранить наш поток вывода для тестов.
     */
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    /**
     * Переменная хранить стандартный поток вывода в консоль.
     */
    private PrintStream systemOutput = System.out;

    /**
     * Перед всеми тестами заменяет стандартный вывод в консоль.
     */
    @Before
    public void changesOutStream() {
        System.setOut(new PrintStream(output));
    }

    /**
     * Тестируем создание объекта Барсик.
     */
    @Test
    public void whenCreateBarsikThenShowData() {
        Cat barsik = new Cat();
        String name = "Barsik";
        String food = "meat";
        barsik.giveNick(name);
        barsik.eat(food);
        barsik.show();
        String expected = "Barsik meat" + System.lineSeparator();
        assertEquals(expected, this.output.toString());
    }

    /**
     * Тест выполняется после всех тестов для замены потока вывода.
     */
    @After
    public void cleanUpStreams() {
        System.setOut(systemOutput);
    }
}
