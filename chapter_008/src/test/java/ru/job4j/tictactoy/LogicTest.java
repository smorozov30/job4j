package ru.job4j.tictactoy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Класс тест на Logic.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class LogicTest {

    /**
     * Класс логики игры.
     */
    private Logic logic;

    /**
     * Предварительное заполнение поля несколькими ходами игроков.
     */
    @Before
    public void beforeTests() {
        this.logic = new Logic(3);
        assertTrue(this.logic.setCell(0));
        assertTrue(this.logic.setCell(1));
        assertTrue(this.logic.setCell(4));
        assertTrue(this.logic.setCell(5));
    }

    /**
     * Тестируем вывод поля игры в виде строки.
     */
    @Test
    public void whenCreateBoardThenReturnAsString() {
        StringBuilder builder = new StringBuilder();
        builder.append("X|O| ").append("\n")
                .append("-+-+-").append("\n")
                .append(" |X|O").append("\n")
                .append("-+-+-").append("\n")
                .append(" | | ").append("\n");
        String expected = builder.toString();
        assertThat(this.logic.getBoard(), is(expected));

    }

    /**
     * Тестируем ход игрока в ячейку 6, и затем повторный ход в эту же ячейку.
     */
    @Test
    public void whenSetSignReturnTrue() {
        assertTrue(this.logic.setCell(6));
        assertFalse(this.logic.setCell(6));
    }

    /**
     * Тестируем определение победителя на поле.
     */
    @Test
    public void whenHaveWinnerThenReturnTrue() {
        assertTrue(this.logic.setCell(8));
        assertTrue(this.logic.checkWinner());
    }

    /**
     * Тестируем полное заполнение поля.
     */
    @Test
    public void isFilled() {
        assertFalse(this.logic.isFilled());
        assertTrue(this.logic.setCell(2));
        assertTrue(this.logic.setCell(3));
        assertTrue(this.logic.setCell(6));
        assertTrue(this.logic.setCell(7));
        assertTrue(this.logic.setCell(8));
        assertTrue(this.logic.isFilled());
    }

    /**
     * Тестируем получение символа расположеного последним на поле.
     */
    @Test
    public void getLastSign() {
        assertThat(this.logic.getLastSign(), is('O'));
    }
}