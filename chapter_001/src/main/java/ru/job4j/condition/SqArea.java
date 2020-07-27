package ru.job4j.condition;

/**
 * Класс рассчитывающий площадь треугольника по периметру и коэффициенту.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class SqArea {

    /**
     * Рассчитывает полощадь треугольника по периметру и коэффициенту.
     * @param p - периметр треугольника.
     * @param k - коэффициент.
     * @return - площадь треугольника.
     */
    public static int square(int p, int k) {
        int h = p / (2 * (k + 1));
        int w = k * h;
        int s = w * h;
        return s;
    }
}
