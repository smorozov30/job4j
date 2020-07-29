package ru.job4j.sort;

/**
 * Класс выполняе слияние двух отсортированных массивов.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Merge {

    /**
     * Метод выполняет слияние двух принятых массивов.
     * @param left - первый массив.
     * @param right - второй массив.
     * @return - массив, результат слияния.
     */
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < rsl.length) {
            if (i > left.length - 1) {
                rsl[k++] = right[j];
                j++;
            } else if (j > right.length - 1) {
                rsl[k++] = left[i];
                i++;
            } else if (left[i] < right[j]) {
                rsl[k++] = left[i];
                i++;
            } else {
                rsl[k++] = right[j];
                j++;
            }
        }
        return rsl;
    }
}
