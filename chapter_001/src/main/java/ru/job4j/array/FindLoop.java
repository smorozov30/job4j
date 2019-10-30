package ru.job4j.array;

/**
 * FindLoop Класс определяет наличие элемента в массиве
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class FindLoop {

    /**
     * indexOf Метод определяет наличие принятого элеманта в принятом масииве
     * @param data - массив чисел
     * @param el - элемент для поиска
     * @return - индекс элемента или -1 если элемент найден не был
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
