package ru.job4j.tracker;

/**
 * Класс представляет консольное приложение для работы с классом Tracker.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class StartUI {
    /**
     * В методе выполняется работа с меню.
     * Пользователь вводит номер пункта меню и по требованию необходимые данные для выполнения требуемой операции.
     * @param input объект класса ConsoleInput, используется для ввода данных с консоли.
     * @param tracker объект класса Tracker, является оберткой для массива заявок, используется для работы с заявками.
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            System.out.println(actions.length + ". ======== Exit =========");
            int select = input.askInt("Select: ");
            if (select >= actions.length) {
                break;
            }
            run = actions[select].execute(input, tracker);
        }
    }

    /**
     * Метод выводит в консоль пункты меню приложения.
     */
    private void showMenu(UserAction[] actions) {
        System.out.println("========== Menu ==========");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    /**
     * С этого метода начинается работа приложения.
     * @param args - args.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ShowAllAction(), new ReplaceAction(),
                                new DeleteAction(), new FindByIdAction(), new FindByNameAction()};
        new StartUI().init(input, tracker, actions);
    }
}
