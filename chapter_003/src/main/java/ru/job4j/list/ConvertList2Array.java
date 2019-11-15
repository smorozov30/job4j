package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() * 1.0 / rows);
        int[][] array = new int[rows][cells];
        int indexList = 0;
        int indexCells = 0;
        for (int[] row : array) {
            for (int cell : row) {
                if (indexList < list.size()) {
                    row[indexCells++] = list.get(indexList++);
                } else {
                    row[indexCells++] = 0;
                }
            }
            indexCells = 0;
        }
        return array;
    }
}
