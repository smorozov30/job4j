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
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 6) {
                run = false;
            } else if (select == 0) {
                System.out.println("=== Create a new Item ====");
                Item item = new Item(input.askStr("Enter name: "));
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Items ====");
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                Item previous = tracker.findById(input.askStr("Enter id: "));
                System.out.println();
                if (previous != null) {
                    Item next = new Item(input.askStr("Enter a name to replace: "));
                    next.setId(previous.getId());
                    tracker.replace(previous.getId(), next);
                    System.out.println();
                    System.out.println("Item replaced");
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                String id = input.askStr("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                Item item = tracker.findById(input.askStr("Enter id: "));
                if (item != null) {
                    System.out.println("Item found: " + item.getName());
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                Item[] items = tracker.findByName(input.askStr("Enter a name to search: "));
                System.out.println();
                if (items.length > 0) {
                    System.out.println(items.length + " items found:");
                    for (Item item : items) {
                        System.out.println(item.getName() + ": id(" + item.getId() + ")");
                    }
                } else {
                    System.out.println("Items not found");
                }
            }
        }
    }

    /**
     * Метод выводит в консоль пункты меню приложения.
     */
    private void showMenu() {
        System.out.println("====== Menu.======");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * С этого метода начинается работа приложения.
     * @param args - args.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
