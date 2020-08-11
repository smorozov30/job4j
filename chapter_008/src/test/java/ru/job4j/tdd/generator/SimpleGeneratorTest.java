package ru.job4j.tdd.generator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Тест на класс SimpleGenerator.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class SimpleGeneratorTest {

    /**
     * Поле хранит объект генератор.
     */
    private Generator generator;

    /**
     * Поле хранит шаблон.
     */
    private String template;

    /**
     * Поле хранит аргументы для подстановки.
     */
    private Map<String, String> args;

    /**
     * Подготовка полей класса к тестам.
     */
    @Before
    public void beforeTests() {
        this.generator = new SimpleGenerator();
        this.template = "I am a ${name}, Who are ${subject}?";
        this.args = new HashMap<>();
    }

    /**
     * Тестируем нормальную работу генератора.
     */
    @Ignore
    @Test
    public void whenTransferTrueDataReturnTrueString() {
        this.args.put("name", "Sergey");
        this.args.put("subject", "you");
        String result = this.generator.produce(this.template, this.args);
        String expected = "I am a Sergey, Who are you?";
        assertThat(result, is(expected));
    }

    /**
     * Тестируем получение исключения при лишних ключах в шаблоне.
     */
    @Ignore
    @Test (expected = KeysInTemplateIsMoreException.class)
    public void whenTransferFalseArgsReturnException() {
        this.args.put("name", "Sergey");
        this.generator.produce(this.template, this.args);
    }

    /**
     * Тестируем получение исключения при лишних ключах в переданых аргументах.
     */
    @Ignore
    @Test (expected = KeysInArgsIsMore.class)
    public void whenTransferFalseTemplateReturnException() {
        this.args.put("name", "Sergey");
        this.generator.produce(this.template, this.args);
    }
}