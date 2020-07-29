package ru.job4j.array;

/**
 * Класс осуществляет поиск минимального числа в массиве.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Min {

    /**
     * Метод ищет минимальное число в массиве.
     * @param array - массив.
     * @return - минимальное число.
     */
    public static int findMin(int[] array) {
        int min = array[0];
        for (int index = 0; index < array.length; index++) {
            if (min > array[index]) {
                min = array[index];
            }
        }
        return min;
    }
}
