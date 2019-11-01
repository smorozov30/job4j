package ru.job4j.tracker;

/**
 * Класс осуществляет действие поиска заявки по id.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class FindByIdAction implements UserAction {

    /**
     * Метод возвращает название действия, за которое отвечает класс.
     * @return строка.
     */
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    /**
     * Метод ищет заявку по id используя метод из класса Tracker.
     * @param input объект класса отвечающий за ввод данных.
     * @param tracker основной класс для работы с заявками.
     * @return результат выполнения добавления.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        Item item = tracker.findById(input.askStr("Enter id: "));
        if (item != null) {
            System.out.println("Item found: " + item.getName());
            result = true;
        } else {
            System.out.println("Item not found");
        }
        return result;
    }
}
