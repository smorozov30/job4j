package ru.job4j.array;

/**
 * Matrix Класс создает талицу умножения заданного размера
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class Matrix {
    /**
     * multiple Метод принимает размер таблицы умноженияб создает таблицу и возвращает ее
     * @param size - требуемый размер таблицы умножения
     * @return - созданная таблица
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
