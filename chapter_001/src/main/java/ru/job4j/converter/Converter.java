package ru.job4j.converter;

/**
 * Класс конвертер для перевода валюты.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Converter {

    /**
     * Метод переводит рубли в евро.
     * @param value - количество рублей.
     * @return - количество евро.
     */
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Метод переводит рубли в доллары.
     * @param value - количество рублей.
     * @return - количество долларов.
     */
    public static int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Метод переводит евро в рубли.
     * @param value - количество евро.
     * @return - количество рублей.
     */
    public static int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Метод переводит доллары в рубли.
     * @param value - количество долларов.
     * @return - количество рублей.
     */
    public static int dollarToRuble(int value) {
        return value * 60;
    }
}
