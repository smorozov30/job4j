package ru.job4j.calculator;

/**
 * Класс для расчета идеального веса мужчины/женщины.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Fit {

    /**
     * Вычисление идеального веса для мужчин.
     * @param height - рост мужчины.
     * @return - идеальный вес.
     */
    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Вычисление идеального веса для женщины.
     * @param height - рост женщины.
     * @return - идеальный вес.
     */
    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
