package ru.job4j.array;

/**
 * Defragment Класс выполняет дефрагментацию массива строк
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */

public class Defragment {
    /**
     * compress Метод принимает массив строк и выполняет его дефрагментацию
     * @param array - не дефрагментированный массив строк
     * @return - дефрагментированный массив
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
            System.out.println(array[index] + " ");
        }
        return array;
    }

    /**
     * main Главный метод, здесь используется для ручного тестирования метода compress
     * @param args - args
     */
    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }

}
