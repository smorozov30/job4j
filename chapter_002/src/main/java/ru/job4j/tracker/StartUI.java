package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

/**
 * Класс представляет консольное приложение для работы с классом Tracker.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class StartUI {
    /**
     * В методе выполняется работа с меню.
     * Пользователь вводит номер пункта меню и по требованию необходимые данные для выполнения требуемой операции.
     * @param input объект класса ValidateInput, используется для ввода данных с консоли.
     * @param tracker объект класса Tracker, является оберткой для массива заявок, используется для работы с заявками.
     */
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            System.out.println(actions.size() + ". ======== Exit =========");
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Метод выводит в консоль пункты меню приложения.
     */
    private void showMenu(List<UserAction> actions) {
        System.out.println("========== Menu ==========");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    /**
     * С этого метода начинается работа приложения.
     * @param args - args.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                                new CreateAction("= Create a new Item ==="),
                                new ShowAllAction("====== All Items ======"),
                                new ReplaceAction("===== Edit item ======="),
                                new DeleteAction("===== Delete item ====="),
                                new FindByIdAction("=== Find item by Id ==="),
                                new FindByNameAction("= Find items by name ==")
                                );
        new StartUI().init(validate, tracker, actions);
    }
}
