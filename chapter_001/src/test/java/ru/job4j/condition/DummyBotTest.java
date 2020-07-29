package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Тест для класса DummyBot.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class DummyBotTest {

    /**
     * Тестируем создание экземпляра класса DummyBot.
     */
    @Test
    public void whenCreateClassThenReturnNotNull() {
        DummyBot dummyBot = new DummyBot();
        assertNotNull(dummyBot);
    }

    /**
     * Тестируем приветствие бота.
     */
    @Test
    public void whenGreetBot() {
        assertThat(DummyBot.answer("Привет, Бот."), is("Привет, умник."));
    }

    /**
     * Тестируем прощание бота.
     */
    @Test
    public void whenByeBot() {
        assertThat(DummyBot.answer("Пока."), is("До скорой встречи."));
    }

    /**
     * Тестируем глупость бота.
     */
    @Test
    public void whenUnknowBot() {
        assertThat(DummyBot.answer("Сколько будет 2 + 2?"), is("Это ставит меня в тупик. Задайте другой вопрос."));
    }
}
