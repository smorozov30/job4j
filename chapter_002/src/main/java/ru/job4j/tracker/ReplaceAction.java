package ru.job4j.tracker;

/**
 * Класс осуществляет действие замены старой заявки - новой.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class ReplaceAction implements UserAction {

    /**
     * Метод возвращает название действия, за которое отвечает класс.
     * @return строка.
     */
    @Override
    public String name() {
        return "===== Edit item =======";
    }

    /**
     * Метод заменяет заявку по id, используя метод из класса Tracker.
     * @param input объект класса отвечающий за ввод данных.
     * @param tracker основной класс для работы с заявками.
     * @return результат выполнения добавления.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        Item previous = tracker.findById(input.askStr("Enter id: "));
        System.out.println();
        if (previous != null) {
            Item next = new Item(input.askStr("Enter a name to replace: "));
            next.setId(previous.getId());
            tracker.replace(previous.getId(), next);
            result = true;
            System.out.println();
            System.out.println("Item replaced");
        } else {
            System.out.println("Item not found");
        }
        return result;
    }
}
