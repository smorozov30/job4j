package ru.job4j.srp;

import java.util.Arrays;
import java.util.List;

public class InteractCalc {
    private CalculateAction lastAct;
    private double lastCalc;


    public void start(List<CalculateAction> actions, Input input, Output output) {
        while (true) {
            this.showMenu(actions, output);
            CalculateAction action = null;
            int index = Integer.parseInt(input.input(output, "Введите пункт меню:"));
            if (index == actions.size()) {
                this.lastCalc = lastAct.execute(input, output);
            } else if (index == actions.size() + 1) {
                index = Integer.parseInt(input.input(output, "Выберите операцию:"));
                action = actions.get(index);
                this.lastAct = action;
                this.lastCalc = action.execute(input, output, this.lastCalc);
            } else if (index == actions.size() + 2) {
                break;
            } else {
                action = actions.get(index);
                this.lastAct = action;
                this.lastCalc = action.execute(input, output);
            }
        }
    }

    private void showMenu(List<CalculateAction> actions, Output output) {
        for (int i = 0; i < actions.size(); i++) {
            output.output(String.format("%d. %s", i, actions.get(i).getName()));
        }
        output.output(String.format("%d. == Повтор операции ==", actions.size()));
        output.output(String.format("%d. == Использовать предыдущее вычисление ==", actions.size() + 1));
        output.output(String.format("%d. ===== Выход =====", actions.size() + 2));
    }

    public static void main(String[] args) {
        InteractCalc calculator = new InteractCalc();
        List<CalculateAction> actions = Arrays.asList(
                new AddAction("====== add ====="),
                new SubtractAction("====== subtract ======"),
                new MultipleAction("===== multiple ======="),
                new DivideAction("===== divide =====")
        );
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        calculator.start(actions, input, output);
    }
}
