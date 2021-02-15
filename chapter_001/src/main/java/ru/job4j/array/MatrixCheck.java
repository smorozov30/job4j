package ru.job4j.array;

/**
 *  Класс проверят выигрышную комбинацию из 5 символов в матрице.
 *
 *  @author Sergey Morozov (morozov.java.job@gmail.com)
 *  @version 1.0
 */
public class MatrixCheck {

    /**
     * Метод проверят выигрышную комбинацию из 5 символов в матрице.
     * @param board - матрица для поиска выигрышной комбинации.
     * @return - результат поиска комбинации.
     */
    public boolean isWin(char[][] board) {
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
            char sign = board[row][row];
                if (sign == 'X') {
                    if (monoHorizontal(board, row) || monoVertical(board, row)) {
                        result = true;
                    }
                }
        }
        return result;
    }

    /**
     * Проверяет выигрышную комбинацию по горизонталям.
     * @param board - доска с фигурами.
     * @param index - индекс проверяемой линии.
     * @return - результат проверки.
     */
    public boolean monoHorizontal(char[][] board, int index) {
        int countHorizontal = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[index][i] == 'X') {
                countHorizontal++;
            }
        }
        return countHorizontal == board.length;
    }

    /**
     * Проверяет выигрышную комбинацию по вертикали.
     * @param board - доска с фигурами.
     * @param index - индекс проверяемой колонны.
     * @return - результат проверки.
     */
    public boolean monoVertical(char[][] board, int index) {
        int countVertical = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][index] == 'X') {
                countVertical++;
            }
        }
        return countVertical == board.length;
    }
}
