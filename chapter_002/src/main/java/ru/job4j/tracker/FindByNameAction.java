package ru.job4j.tracker;

import java.util.List;

/**
 * Класс осуществляет действие поиска заявки по имени.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class FindByNameAction extends BaseAction {

    protected FindByNameAction(String name) {
        super(name);
    }

    /**
     * Метод ищет заявку по имени, используя метод из класса Tracker.
     * @param input объект класса отвечающий за ввод данных.
     * @param tracker основной класс для работы с заявками.
     * @return результат выполнения добавления.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        List<Item> items = tracker.findByName(input.askStr("Enter a name to search: "));
        System.out.println();
        if (items.size() > 0) {
            System.out.println(items.size() + " items found:");
            for (Item item : items) {
                System.out.println(item.getName() + ": id(" + item.getId() + ")");
            }
            result = true;
        } else {
            System.out.println("Items not found");
        }
        return result;
    }
}
