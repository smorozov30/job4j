package ru.job4j.array;

/**
 * Класс ищет элемент в массиве.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 */
public class FindLoop {

    /**
     * Метод ищет заданный элемент в массиве.
     * @param data - массив чисел.
     * @param el - элемент для поиска.
     * @return - индекс элемента или -1 если элемент найден не был.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (el == data[i]) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод ищет элемент в диапазоне индексов массива.
     * @param data - массив чисел.
     * @param el - элемент для поиска.
     * @param start - индекс начало поиска.
     * @param finish - индекс конца поиска.
     * @return - результат поиска.
     */
    public static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int i = start; i <= finish; i++) {
            if (el == data[i]) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
