package ru.job4j.tictactoy;

/**
 * Класс логики игры "Крестики-нолики".
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Logic {

    public static final char X = 'X';
    public static final char O = 'O';

    /**
     * Доска для игры.
     */
    private char[][] board;

    /**
     * Флаг для поперемнного размещения ходов на доске.
     */
    private boolean flag = true;

    /**
     * Количество пустых клеток на поле.
     */
    private int emptyCells;

    /**
     * Коструктор класса.
     * @param size - размер поля для игры.
     */
    public Logic(int size) {
        this.board = new char[size][size];
        this.emptyCells = size * size;
    }

    /**
     * Выводит поле игры в виде строки.
     * @return - поле игры.
     */
    public String getBoard() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < this.board.length; row++) {
            for (int cell = 0; cell < this.board.length; cell++) {
                builder.append(this.board[row][cell] != '\u0000' ? this.board[row][cell] : ' ');
                if (cell != this.board.length - 1) {
                    builder.append('|');
                }

            }
            builder.append("\n");
            if (row != this.board.length - 1) {
                for (int i = 0; i < this.board.length; i++) {
                    builder.append('-');
                    if (i != this.board.length - 1) {
                        builder.append('+');
                    }
                }
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    /**
     * Вставляет символ на доску по индексу.
     * @param index - индекс ячейки.
     * @return - результат вставки символа.
     */
    public boolean setCell(int index) {
        boolean result = false;
        int row = index / this.board.length;
        int cell = index % this.board.length;
        if (this.board[row][cell] == '\u0000') {
            this.board[row][cell] = this.flag ? X : O;
            this.flag = !this.flag;
            this.emptyCells = this.emptyCells - 1;
            result = true;
        }
        return result;
    }

    /**
     * Проверяет есть ли победитель на поле.
     * @return
     */
    public boolean checkWinner() {
        return this.checkLines(X)
                || this.checkDiagonals(X)
                || this.checkLines(O)
                || this.checkDiagonals(O);
    }

    /**
     * Ищет победителя по горизонтальным и вертикальным линиям.
     * @param sign
     * @return
     */
    private boolean checkLines(char sign) {
        for (int row = 0; row < this.board.length; row++) {
            if (this.board[row][row] == sign) {
                int countV = 0;
                int countH = 0;
                for (int i = 0; i < this.board.length; i++) {
                    if (this.board[row][i] == sign) {
                        countH++;
                    }
                    if (this.board[i][row] == sign) {
                        countV++;
                    }
                }
                if (countH == this.board.length || countV == this.board.length) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Ищет победителя по диагоналям.
     * @param sign
     * @return
     */
    private boolean checkDiagonals(char sign) {
        int countL = 0;
        int countR = 0;
        for (int row = 0; row < this.board.length; row++) {
            if (this.board[row][row] == sign) {
                countL++;
            }
            if (this.board[this.board.length - 1 - row][row] == sign) {
                countR++;
            }
            if (countL == this.board.length || countR == this.board.length) {
                return true;
            }
        }
        return false;
    }

    /**
     * Заполнено ли поле полностью символами.
     * @return
     */
    public boolean isFilled() {
        return this.emptyCells == 0;
    }

    /**
     * Возвращает последний поставленый символ на доске.
     * @return
     */
    public char getLastSign() {
        return !this.flag ? X : O;
    }

    public int size() {
        return this.board.length;
    }
}