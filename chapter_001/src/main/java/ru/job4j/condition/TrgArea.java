package ru.job4j.condition;

/**
 * Класс расчитывает площадь треугольника по длинне трех сторон.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class TrgArea {

    /**
     * Метод расчитывает полощадь треугольника по длинне сторон.
     * @param a - длина первой стороны.
     * @param b - длина второй стороны.
     * @param c - длина третей стороны.
     * @return - площадь треугольника.
     */
    public static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double resultSq = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return resultSq;
    }
}
