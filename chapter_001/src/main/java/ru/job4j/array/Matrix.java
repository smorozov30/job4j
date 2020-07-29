package ru.job4j.array;

/**
 * Класс создает таблицу умножения заданного размера.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Matrix {

    /**
     * Метод принимает размер таблицы умножения и создает таблицу.
     * @param size - требуемый размер таблицы умножения.
     * @return - созданная таблица.
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
