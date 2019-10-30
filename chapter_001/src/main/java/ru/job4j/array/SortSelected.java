package ru.job4j.array;

/**
 * SortSelected Класс сортирует числовой массив по возрастанию
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class SortSelected {

    /**
     * sort Метод принимает числовой массив и сортирует его по возрастанию
     * @param data - числовой массив, который требуется отсортировать по возрастанию
     * @return - отсортированный массив
     */
    public static int[] sort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            int min = MinDiapason.findMin(data, i, data.length - 1);
            int index = FindLoop.indexOf(data, min, i, data.length - 1);

            int temp = data[i];
            data[i] = data[index];
            data[index] = temp;
        }
        return data;
    }
}
