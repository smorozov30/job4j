package ru.job4j.array;

/**
 * Класс выполняет дефрагментацию массива строк.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */

public class Defragment {
    /**
     * Метод принимает массив строк и выполняет его дефрагментацию.
     * @param array - не дефрагментированный массив строк.
     * @return - дефрагментированный массив.
     */
    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length; index++) {
            String cell = array[index];
            if (cell == null) {
                int i = index;
                while (i < array.length) {
                    if (array[i] != null) {
                       array[index] = array[i];
                       array[i] = null;
                       break;
                    }
                    i++;
                }
            }
        }
        return array;
    }
}
