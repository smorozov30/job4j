package ru.job4j.condition;

/**
 * Класс сравнивающий числа.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Max {

    /**
     * Метод сравнивает два числа.
     * @param left - первое число.
     * @param right - второе число.
     * @return - результат сравнения - большее число.
     */
    public static int max(int left, int right) {
        int result = (left > right) ? left : right;
        return result;
    }

    /**
     * Метод сравнивает три числа.
     * @param left - первое число.
     * @param right - второе число.
     * @param top - третье число.
     * @return - результат сравнения - большее число.
     */
    public static int max(int left, int right, int top) {
        int result = max(left, max(right, top));
        return result;
    }

    /**
     * Метод сравнивает четфре числа.
     * @param left - первое число.
     * @param right - второе число.
     * @param top - третье число.
     * @param bottom - четвертое число.
     * @return - результат сравнения - большее число.
     */
    public static int max(int left, int right, int top, int bottom) {
        int result = max(max(left, right), max(top, bottom));
        return result;
    }
}