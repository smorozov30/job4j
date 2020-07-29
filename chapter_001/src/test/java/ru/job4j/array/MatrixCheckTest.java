package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тест на класс MatrixCheck.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MatrixCheckTest {

    private MatrixCheck matrixCheck;

    /**
     * Переменная с победной комбинацией по горизинтали.
     */
    private static char[][] hasHor = {
            {'_', '_', '_', '_', '_'},
            {'X', 'X', 'X', 'X', 'X'},
            {'_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_'},
            {'_', '_', '_', '_', '_'},
    };

    /**
     * Переменная с победной комбинацией по вертикали.
     */
    private static char[][] hasVertical = {
            {'_', '_', 'X', '_', '_'},
            {'_', '_', 'X', '_', '_'},
            {'_', '_', 'X', '_', '_'},
            {'_', '_', 'X', '_', '_'},
            {'_', '_', 'X', '_', '_'},
    };

    /**
     * Переменная без победной комбинации.
     */
    private static char[][] hasNotWin = {
            {'_', '_', 'X', '_', '_'},
            {'_', '_', '_', 'X', '_'},
            {'_', '_', 'X', '_', '_'},
            {'_', '_', 'X', '_', '_'},
            {'_', '_', 'X', '_', '_'},
    };

    @Before
    public void createObjectMatrixCheck() {
        this.matrixCheck = new MatrixCheck();
        assertNotNull(matrixCheck);
    }

    /**
     * Тестируем выигрышную компинацию по вертикали.
     */
    @Test
    public void whenIsWinVerticalThenTrue() {
        boolean result = this.matrixCheck.isWin(hasVertical);
        assertTrue(result);
    }

    /**
     * Тестируем выигрышную компинацию по горизонтали.
     */
    @Test
    public void whenIsWinHorizontalThenTrue() {
        boolean result = this.matrixCheck.isWin(hasHor);
        assertTrue(result);
    }

    /**
     * Тестируем отсутствие выигрышной компинации.
     */
    @Test
    public void whenIsNotWinThenFalse() {
        boolean result = this.matrixCheck.isWin(hasNotWin);
        assertFalse(result);
    }

    /**
     * Тестируем выигрышную компинацию по горизонтали.
     */
    @Test
    public void whenMonoHorizontalThenTrue() {
        boolean result = this.matrixCheck.monoHorizontal(hasHor, 1);
        assertTrue(result);
    }

    /**
     * Тестируем выигрышную компинацию по вертикали.
     */
    @Test
    public void whenMonoVerticalThenTrue() {
        boolean result = this.matrixCheck.monoVertical(hasVertical, 2);
        assertTrue(result);
    }

    /**
     * Тестируем отсутствие выигрышной компинации по горизонтали.
     */
    @Test
    public void whenMonoHorizontalThenFalse() {
        boolean result = this.matrixCheck.monoHorizontal(hasHor, 2);
        assertFalse(result);
    }

    /**
     * Тестируем отсутствие выигрышной компинации по вертикали.
     */
    @Test
    public void whenMonoVerticalThenFalse() {
        boolean result = this.matrixCheck.monoVertical(hasVertical, 3);
        assertFalse(result);
    }
}