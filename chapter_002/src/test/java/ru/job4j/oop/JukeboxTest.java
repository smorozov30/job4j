package ru.job4j.oop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Тест на класс Jukebox.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class JukeboxTest {
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
     * Тестируем вывод песни "Пусть бегут неуклюже".
     */
    @Test
    public void whenSetPositionOne() {
        Jukebox jukebox = new Jukebox();
        int position = 1;
        jukebox.music(position);
        String expected = "Пусть бегут неуклюже,"
                        + System.lineSeparator()
                        + "Пешеходы по лужам,"
                        + System.lineSeparator()
                        + "А вода по асфальту рекой."
                        + System.lineSeparator()
                        + "И неясно прохожим,"
                        + System.lineSeparator()
                        + "В этот день непогожий,"
                        + System.lineSeparator()
                        + "Почему я веселый такой."
                        + System.lineSeparator();
        assertEquals(expected, this.out.toString());
    }

    /**
     * Тестируем вывод песни "Спокойной ночи".
     */
    @Test
    public void whenSetPositionTwo() {
        Jukebox jukebox = new Jukebox();
        int position = 2;
        jukebox.music(position);
        String expected = "Спят усталые игрушки, книжки спят."
                        + System.lineSeparator()
                        + "Одеяла и подушки ждут ребят."
                        + System.lineSeparator()
                        + "Даже сказка спать ложится,"
                        + System.lineSeparator()
                        + "Чтобы ночью нам присниться."
                        + System.lineSeparator()
                        + "Ты ей пожелай:"
                        + System.lineSeparator()
                        + "Баю-бай."
                        + System.lineSeparator();
        assertEquals(expected, this.out.toString());
    }

    /**
     * Тестируем вывод песни "Спокойной ночи".
     */
    @Test
    public void whenSetOtherPosition() {
        Jukebox jukebox = new Jukebox();
        int position = 3;
        jukebox.music(position);
        String expected = "Песня не найдена" + System.lineSeparator();
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