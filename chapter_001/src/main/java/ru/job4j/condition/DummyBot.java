package ru.job4j.condition;

/**
 * Класс преставляющий глупого бота.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class DummyBot {

    /**
     * Метод принимает ввод пользователя, и дает ответ одним из трех вариантов.
     * @param question - ввод пользователя в метод.
     * @return - ответ бота.
     */
    public static String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
