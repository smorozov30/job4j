package ru.job4j.loop;

/**
 * Класс выводит в консоль шахматную доску.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Board {

    /**
     * Метод выводит в консоль шахматную доску заданного размера.
     * @param width - ширина доски.
     * @param height - высота доски.
     */
    public static void paint(int width, int height) {
        for (int row = 0; row < height; row++) {
            for (int cell = 0; cell < width; cell++) {
                if ((row + cell) % 2 == 0) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
