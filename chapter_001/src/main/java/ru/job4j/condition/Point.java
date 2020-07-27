package ru.job4j.condition;

/**
 * Класс расчитывающий расстояние между двумя точками в системе координат.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Point {

    /**
     * Метод расчитывает расстояние между двумя точками в системе координат.
     * @param x1 - x координата первой точки.
     * @param y1 - y координата первой точки.
     * @param x2 - x координата второй точки.
     * @param y2 - y координата второй точки.
     * @return - расстояние между двумя точками.
     */
    public static double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow((x2 - x1), 2);
        double second = Math.pow((y2 - y1), 2);
        return Math.sqrt(first + second);
    }
}
