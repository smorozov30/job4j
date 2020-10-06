package ru.job4j.tictactoy;

/**
 * Класс представляющий игрока.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Player implements Playable {

    /**
     * Поле хранит интерфейс получения данных.
     */
    private Input input;

    /**
     * Ограничение выдаваемого индекса.
     */
    private int maxIndex;

    public Player(Input input, int endOfRange) {
        this.input = input;
        this.maxIndex = endOfRange;
    }

    /**
     * Возвращает номер ячейки для хода на доске.
     * @return
     */
    @Override
    public int getCell() {
        return this.input.getNumberInRange(this.maxIndex);
    }
}
