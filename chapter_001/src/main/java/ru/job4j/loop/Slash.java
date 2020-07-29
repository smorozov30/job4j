package ru.job4j.loop;

/**
 * Класс рисует крест в консоли.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Slash {

    /**
     * Метод рисует крест в консоли.
     * @param size - размер креста.
     */
    public static void draw(int size) {
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                boolean left = false;
                boolean right = false;
                if (cell == row) {
                    left = true;
                }
                if ((row + cell + 1) == size) {
                    right = true;
                }
                if (left) {
                    System.out.print("0");
                } else if (right) {
                    System.out.print("0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
