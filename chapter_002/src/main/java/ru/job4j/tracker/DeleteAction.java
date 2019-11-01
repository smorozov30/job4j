package ru.job4j.tracker;

/**
 * Класс осуществляет действие удаления заявки.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class DeleteAction implements UserAction {

    /**
     * Метод возвращает название действия, за которое отвечает класс.
     * @return строка.
     */
    @Override
    public String name() {
        return "===== Delete item =====";
    }

    /**
     * Метод удаляет заявку по id используя метод из класса Tracker.
     * @param input объект класса отвечающий за ввод данных.
     * @param tracker основной класс для работы с заявками.
     * @return результат выполнения добавления.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        boolean result = tracker.delete(id);
        System.out.println(result ? "Item deleted" : "Item not found");
        return result;
    }
}
