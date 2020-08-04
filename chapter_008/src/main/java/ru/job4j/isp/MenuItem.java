package ru.job4j.isp;

import java.util.List;

/**
 * Класс элемент меню реализующий три интерфейса для разных действий.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MenuItem implements Action, Animation, Highlight {

    /**
     * Поле хранит название пункта меню.
     */
    private String name;

    /**
     * Поле хранит коллекцию подпунктов меню.
     */
    private List<MenuItem> items;

    /**
     * Конструктор класс.
     * @param name - имя пункта меню.
     */
    public MenuItem(String name) {
        this.name = name;
    }

    /**
     * Возвращает название пункта меню.
     * @return - название.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает коллекцию попунктов меню.
     * @return
     */
    public List<MenuItem> getItems() {
        return this.items;
    }

    /**
     * Добавляет меню коллекцию подпунктов.
     * @param items
     */
    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    /**
     * Реализация первого интерфейса с одним методом вместо "жирного" интерфейса.
     */
    @Override
    public void doAction() {

    }

    /**
     * Реализация второго интерфейса с одним методом вместо "жирного" интерфейса.
     */
    @Override
    public void highlight() {

    }

    /**
     * Реализация третьего интерфейса с одним методом вместо "жирного" интерфейса.
     */
    @Override
    public void animation() {

    }
}
