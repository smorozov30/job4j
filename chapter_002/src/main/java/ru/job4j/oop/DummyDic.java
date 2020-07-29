package ru.job4j.oop;

/**
 * Класс выводит неизвестное ему слово.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class DummyDic {

    /**
     * Метод выводит неизвестное слово.
     * @param eng - слово на английском.
     * @return - строку с пояснением.
     */
    public String engToRus(String eng) {
        String text = "Неизвестное слово." + eng;
        return text;
    }
}
