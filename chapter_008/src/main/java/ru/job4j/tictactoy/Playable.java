package ru.job4j.tictactoy;

/**
 * Интерфейс получения ввода от игрока.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public interface Playable {

    /**
     * Получить индекс ячейки на поле.
     * @return
     */
    int getCell();
}
