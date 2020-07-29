package ru.job4j.oop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Тест на класс Student.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class StudentTest {

    /**
     * Переменная хранит наш поток вывода для тестов.
     */
    private ByteArrayOutputStream out;

    /**
     * Переменная хранить сандартный поток вывода системы.
     */
    private PrintStream sysOut;

    /**
     * Перед всеми тестами заменяем потоки вывода.
     */
    @Before
    public void changesOutStreams() {
        this.out = new ByteArrayOutputStream();
        this.sysOut = System.out;
        System.setOut(new PrintStream(out));
    }

    /**
     * Тестируем возможность студента играть музыку.
     */
    @Test
    public void music() {
        Student sergey = new Student();
        sergey.music();
        String expected = "Tra tra tra" + System.lineSeparator();
        assertEquals(expected, this.out.toString());
    }

    /**
     * Тестируем возможность студента петь.
     */
    @Test
    public void song() {
        Student sergey = new Student();
        sergey.song();
        String expected = "I believe I can fly" + System.lineSeparator();
        assertEquals(expected, this.out.toString());
    }

    /**
     * Тест выполняется после всех тестов для замены потока вывода.
     */
    @After
    public void cleanUpStreams() {
        System.setOut(sysOut);
    }
}