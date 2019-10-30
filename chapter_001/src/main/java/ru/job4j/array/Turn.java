package ru.job4j.array;

/**
 * Turn Класс переворачивает числовой массив
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class Turn {
    /**
     * back Метод принимает числовой массив, переворачивает его и возвращает
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
