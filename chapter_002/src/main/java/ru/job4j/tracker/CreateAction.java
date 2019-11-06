package ru.job4j.tracker;

/**
 * Класс осуществляет действие добавления новой заявки.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class CreateAction extends BaseAction {

    protected CreateAction(String name) {
        super(name);
    }

    /**
     * Метод добавляет новую заявку используя метод из класса Tracker.
     * @param input объект класса отвечающий за ввод данных.
     * @param tracker основной класс для работы с заявками.
     * @return результат выполнения добавления.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = new Item(input.askStr("Enter name: "));
        tracker.add(item);
        System.out.println("Item added");
        return true;
    }
}
