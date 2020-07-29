package ru.job4j.oop;

/**
 * Класс описывающий батарейку.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Battery {

    /**
     * Переменная хранит размер заряда батареи.
     */
    private int load;

    /**
     * Конструктор для создания батареи с начальным зарядом.
     * @param load
     */
    public Battery(int load) {
        this.load = load;
    }

    /**
     * Метод заряжает другую батараю.
     * @param another - другая батарея.
     */
    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    /**
     * Метод геттер для получения заряда батареи.
     * @return - заряд батареи.
     */
    public int getLoad() {
        return load;
    }
}