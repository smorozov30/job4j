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
     * Тестируем вывод поля игры в виде строки.
     */
    @Test
    public void whenCreateBoardThenReturnAsString() {
        Logic logic = new Logic(3);
        assertTrue(logic.setCell(0));
        assertTrue(logic.setCell(1));
        assertTrue(logic.setCell(4));
        assertTrue(logic.setCell(5));
        StringBuilder builder = new StringBuilder();
        builder.append("X|O| ").append("\n")
                .append("-+-+-").append("\n")
                .append(" |X|O").append("\n")
                .append("-+-+-").append("\n")
                .append(" | | ").append("\n");
        String expected = builder.toString();
        assertThat(logic.getBoard(), is(expected));

    }

    /**
     * Тестируем ход игрока в ячейку 6, и затем повторный ход в эту же ячейку.
     */
    @Test
    public void whenSetSignReturnTrue() {
        Logic logic = new Logic(3);
        assertTrue(logic.setCell(0));
        assertTrue(logic.setCell(1));
        assertTrue(logic.setCell(4));
        assertTrue(logic.setCell(5));
        assertTrue(logic.setCell(6));
        assertFalse(logic.setCell(6));
    }

    /**
     * Тестируем определение победителя на поле.
     */
    @Test
    public void whenHaveWinnerThenReturnTrue() {
        Logic logic = new Logic(3);
        assertTrue(logic.setCell(0));
        assertTrue(logic.setCell(1));
        assertTrue(logic.setCell(4));
        assertTrue(logic.setCell(5));
        assertTrue(logic.setCell(8));
        assertTrue(logic.checkWinner());
    }

    /**
     * Тестируем полное заполнение поля.
     */
    @Test
    public void isFilled() {
        Logic logic = new Logic(3);
        assertTrue(logic.setCell(0));
        assertTrue(logic.setCell(1));
        assertTrue(logic.setCell(4));
        assertTrue(logic.setCell(5));
        assertFalse(logic.isFilled());
        assertTrue(logic.setCell(2));
        assertTrue(logic.setCell(3));
        assertTrue(logic.setCell(6));
        assertTrue(logic.setCell(7));
        assertTrue(logic.setCell(8));
        assertTrue(logic.isFilled());
    }

    /**
     * Тестируем получение символа расположеного последним на поле.
     */
    @Test
    public void getLastSign() {
        Logic logic = new Logic(3);
        assertTrue(logic.setCell(0));
        assertTrue(logic.setCell(1));
        assertTrue(logic.setCell(4));
        assertTrue(logic.setCell(5));
        assertThat(logic.getLastSign(), is('O'));
    }
}