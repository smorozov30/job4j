package ru.job4j.calculator;

/**
 * Calculator - класс для вычисления арифметических операций + - * /
 * @author morozsergey30 (morozov.java.job@gmail.com)
 */

public class Calculator {

    /**
     * Метод выполняет сложение двух чисел
     * @param first - первое слагаемое
     * @param second - второе слагаемое
     * @return - возвращает результат сложения
     */
    public static double add(double first, double second) {
        return first + second;
    }

    /**
     * Метод выполняет деление двух чисел
     * @param first - делимое
     * @param second - делитель
     * @return - возвращает результат деления
     */
    public static double div(double first, double second) {
        return first / second;
    }

    /**
     * Метод выполняет умножение двух чисел
     * @param first - множимое
     * @param second - множитель
     * @return - возвращает результат произведения
     */
    public static double multiple(double first, double second) {
        return first * second;
    }

    /**
     * Метод выполняет вычитание двух чисел
     * @param first - уменьшаемое
     * @param second - вычитаемое
     * @return - возвращает результат сложения
     */
    public static double subtract(double first, double second) {
        return first - second;
    }
}
