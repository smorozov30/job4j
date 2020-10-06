package ru.job4j.tictactoy;

import java.util.Scanner;

/**
 * Класс получения ввода с консоли.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class ConsoleInput implements Input {

    /**
     * Получает ввод индекс с консоли.
     * @param max - ограничение максимального ввода.
     * @return
     */
    @Override
    public int getNumberInRange(int max) {
        boolean result = false;
        int num = -1;
        Scanner scanner = new Scanner(System.in);
        while (!result) {
            num = scanner.nextInt();
            if (num >= 0 && num < max) {
                result = true;
            }
        }
        scanner.close();
        return num;
    }
}
