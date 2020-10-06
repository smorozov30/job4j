package ru.job4j.tictactoy;

/**
 * Класс для получения рандомного числа с ограничением по максимуму.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class RandomInput implements Input {

    /**
     * Возвращает рандомное число, ограниченое максимумом.
     * @param max
     * @return
     */
    @Override
    public int getNumberInRange(int max) {
        return (int) (Math.random() * max);
    }
}
