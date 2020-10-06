package ru.job4j.tictactoy;

/**
 * Игра "Крестики-нолики".
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class TicTacToy {
    /**
     * Интерфейс вывода данных.
     */
    private Output output;

    /**
     * Логика игры.
     */
    private Logic logic;

    /**
     * Первый игрок.
     */
    private Playable firstPlayer;

    /**
     * Второй игрок.
     */
    private Playable secondPlayer;

    /**
     * Флаг для поочередной смены игрока.
     */
    private boolean flag;

    /**
     * Конструктор класса TicTacToy.
     * @param output - объект вывода данных.
     * @param logic - логика игры.
     * @param firstPlayer - первый игрок.
     * @param secondPlayer - второй игрок.
     * @param firstStep - какаой игрок первым ходит.
     */
    public TicTacToy(Output output, Logic logic, Playable firstPlayer, Playable secondPlayer, boolean firstStep) {
        this.output = output;
        this.logic = logic;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.flag = firstStep;
    }

    /**
     * Метод запуска игры.
     */
    public void game() {
        this.output.output(this.logic.getBoard());
        while (true) {
            boolean result = this.logic.setCell(flag ? this.firstPlayer.getCell() : this.secondPlayer.getCell());
            if (result) {
                this.flag = !this.flag;
            }
            this.output.output(this.logic.getBoard());
            if (this.logic.checkWinner()) {
                this.output.output(String.format("ПОБЕДА %c!", this.logic.getLastSign()));
                break;
            }
            if (this.logic.isFilled()) {
                this.output.output("НИЧЬЯ!");
                break;
            }
        }
    }

    /**
     * Запуск игры человек против компьютера.
     * @param args - аргументы командной строки.
     */
    public static void main(String[] args) {
        int sizeOgGame = 3;
        Logic logic = new Logic(sizeOgGame);
        Output consoleOutput = System.out::println;
        Input consoleInput = new ConsoleInput();
        Input randomInput = new RandomInput();
        Playable human = new Player(consoleInput,  sizeOgGame * sizeOgGame);
        Playable computer = new Player(randomInput, sizeOgGame * sizeOgGame);
        TicTacToy ttt = new TicTacToy(consoleOutput, logic, human, computer, false);
        ttt.game();

    }
}
