package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс представляет консольное приложение для работы с классом Tracker.
 * @author smorozov30 (sergey.se1ove.morozov@gmail.com).
 */
public class StartUI {
    /**
     * В методе выполняется работа с меню.
     * Пользователь вводит номер пункта меню и по требованию необходимые данные для выполнения требуемой операции.
     * @param scanner объект класса Scanner, используется для ввода данных с консоли.
     * @param tracker объект класса Tracker, является оберткой для массива заявок, используется для работы с заявками.
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 6) {
                run = false;
            } else if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.println("Enter name: ");
                Item item = new Item(scanner.nextLine());
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Items ====");
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                Item previous = tracker.findById(scanner.nextLine());
                System.out.println();
                if (previous != null) {
                    System.out.print("Enter a name to replace: ");
                    Item next = new Item(scanner.nextLine());
                    next.setId(previous.getId());
                    tracker.replace(previous.getId(), next);
                    System.out.println();
                    System.out.println("Item replaced");
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter id: ");
                if (tracker.delete(scanner.nextLine())) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.print("Enter id: ");
                Item item = tracker.findById(scanner.nextLine());
                if (item != null) {
                    System.out.println("Item found: " + item.getName());
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.print("Enter a name to search: ");
                Item[] items = tracker.findByName(scanner.nextLine());
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
