package ru.job4j.tdd.generator;

import java.util.Map;

/**
 * Интерфейс генератора.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public interface Generator {

    /**
     * Подставляет аргументы по ключу в шаблон.
     * @param template - шаблон.
     * @param args - аргументы.
     * @return - полчившаяся строка.
     */
    String produce(String template, Map<String, String> args);
}
