package ru.job4j.tracker;

/**
 * Класс осуществляет действие поиска заявки по имени.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class FindByNameAction implements UserAction {

    /**
     * Метод возвращает название действия, за которое отвечает класс.
     * @return строка.
     */
    @Override
    public String name() {
        return "= Find items by name ==";
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
        Item[] items = tracker.findByName(input.askStr("Enter a name to search: "));
        System.out.println();
        if (items.length > 0) {
            System.out.println(items.length + " items found:");
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