package ru.job4j.tracker;

import java.util.Random;
import java.util.regex.MatchResult;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Константа используемая для генерации случайного id каждой заявки.
     */
    private static final Random RANDOM = new Random();

    /**
     * Метод добавляет заявку в массив заявок.
     * @param item Новая заявка, котрорую нужно добавить в масиив.
     * @return
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Для идентификации каждой заявки создает уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextLong());
    }

    /**
     * Метод заменет один элемент в массиве - другим.
     * @param id Уникальный идентификатор элемента который нужно заменить.
     * @param item Элемент который нужно вставить в массив.
     * @return Результат замены.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        if (this.findById(id) != null) {
            for (int index = 0; index < this.items.length; index++) {
                if (this.items[index] != null && this.items[index].getId().equals(id)) {
                    this.items[index] = item;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод удаляет из массива элемент по уникальному идентификатору.
     * @param id Уникальный идентификатор.
     * @return Результат выполнения удаления.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < items.length; index++) {
            if (this.items[index] != null && (this.items[index].getId()).equals(id)) {
                this.items[index] = null;
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод копирует заполненые ячейки массива items в новый массив и возвращает его.
     * @return Масиив объектов.
     */
    public Item[] findAll() {
        Item[] all = new Item[position];
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index] != null) {
                all[index] = this.items[index];
            } else {
                break;
            }

        }
        return all;
    }

    /**
     * Метод ищет элементы в массиве items по имени и копиркет их в новый массив.
     * @param name Имя объекта для поиска.
     * @return Массив объектов.
     */
    public Item[] findByName(String name) {
        Item[] temp = new Item[position];
        int count = 0;
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index] != null && (this.items[index].getName()).equals(name)) {
                temp[count++] = this.items[index];
            }
        }
        Item[] result = new Item[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    /**
     * Метод находит элемент в массиве по уникальному идентификатору.
     * @param id Уникальный идентификатор для поиска.
     * @return Элемент массива или null, если элемент не найден.
     */
    public Item findById(String id) {
        Item item = null;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && (items[index].getId()).equals(id)) {
                item = items[index];
                break;
            }
        }
        return item;
    }
}
