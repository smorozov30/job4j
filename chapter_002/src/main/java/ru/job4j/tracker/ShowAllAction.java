package ru.job4j.tracker;

/**
 * Класс осуществляет действие вывода всех заявок.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class ShowAllAction extends BaseAction {

    protected ShowAllAction(String name) {
        super(name);
    }

    /**
     * Метод показывает все заявки используя метод из класса Tracker.
     * @param input объект класса отвечающий за ввод данных.
     * @param tracker основной класс для работы с заявками.
     * @return результат выполнения добавления.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            System.out.println(items.length + " items found:");
            for (Item item : items) {
                System.out.println(item.getName());
            }
            result = true;
        } else {
            System.out.println("No items found");
        }
        return result;
    }
}
