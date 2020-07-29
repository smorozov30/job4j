package ru.job4j.array;

/**
 * Класс переворачивает числовой массив.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Turn {

    /**
     * Метод принимает числовой массив, переворачивает его и возвращает.
     * @param array - исходный числовой массив
     * @return перевернутый массив
     */
    public int[] back(int[] array) {

        int size = (array.length / 2) - 1;
        for (int i = 0; i <= size; i++) {
            int start = i;
            int end = array.length - 1 - i;
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        return array;
    }
}
