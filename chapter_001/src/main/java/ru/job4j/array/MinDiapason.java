package ru.job4j.array;

/**
 * MinDiapason Класс ищет минимальное число в переденном диапазоне индексов массива
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class MinDiapason {

    /**
     * Метод примает массив и диапазон индексовб ищет минимальное число в диапазоне и возвращает его
     * @param array - массив для поиска
     * @param start - индекс начало диапазона поиска
     * @param finish - индекс конец диапазона поиска
     * @return - минимальное значение в диапазоне поиска
     */
    public static int findMin(int[] array, int start, int finish) {
        int min = array[start];
        for (int i = start; i <= finish; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
