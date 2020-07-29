package ru.job4j.condition;

/**
 * Класс проверяет может ли существовать треугольник.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Triangle {

    /**
     * Метод проверят существование треугольника, принимая длины его сторон.
     * @param ab - длина стороны ab.
     * @param ac - длина стороны ac.
     * @param bc - длина стороны bc.
     * @return - существует или не существует.
     */
    public static boolean exist(double ab, double ac, double bc) {
        boolean result = false;
        if (((ab + ac) > bc) && ((ab + bc) > ac) && ((bc + ac) > ab)) {
            result = true;
        }
        return result;
    }
}
