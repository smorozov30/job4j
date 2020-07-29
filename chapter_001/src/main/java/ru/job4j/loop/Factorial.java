package ru.job4j.loop;

/**
 * Класс вычисляющий факториал числа.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Factorial {

    /**
     * Метод вычисляет факториал числа.
     * @param n - число, факториал которого нужно вычислить.
     * @return - результат вычисления факториала.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
