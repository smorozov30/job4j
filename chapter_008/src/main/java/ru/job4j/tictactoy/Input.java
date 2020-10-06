package ru.job4j.tictactoy;

/**
 * Интерфейс ввода данных.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public interface Input {

    /**
     * Возвращает цифру, ограниченую максимумом.
     * @param max - ограничение возвращаемого числа.
     * @return
     */
    int getNumberInRange(int max);
}
