package ru.job4j.array;

/**
 *  MatrixCheck Класс ищет выигрышную комбинацию из 5 символов в матрице
 *   @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class MatrixCheck {

    /**
     * isWin Метод принимает доску с символами и ищет на ней строку или столбец из пяти последовательно стоящих
     *       одинаковых символов.
     * @param board - матрица для поиска выигрышной комбинации
     * @return - результат поиска комбинации
     */
    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
                char sign = board[row][row];
                System.out.print(sign);
                    if (sign == 'X') {
                    int countVertical = 0;
                    int countHorizontal = 0;
                    for (int i = 0; i < board.length; i++) {
                        if (board[row][i] == 'X') {
                            countHorizontal++;
                        }
                        if (board[i][row] == 'X') {
                            countVertical++;
                        }
                    }
                    if (countVertical == 5 || countHorizontal == 5) {
                        result = true;
                        return result;
                    } else {
                        result = false;
                        return result;
                    }
                }
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }

}
