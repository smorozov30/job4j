package ru.job4j.condition;

/**
 * Класс сравнивающий три числа.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MultiMax {

    /**
     * Метод принимает три числа и сравнивает их между собой.
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @return - возвращает самое большое число.
     */
    public int max(int first, int second, int third) {
        int resultOne = (first > second) ? first : second;
        int resultTwo = (resultOne > third) ? resultOne : third;
        return resultTwo;
    }
}
