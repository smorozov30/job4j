package ru.job4j.lsp.parking;

/**
 * Класс представляющий грузовой автомобиль.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Truck implements Car {

    /**
     * Поле хранит размер машины.
     */
    private static int size = 2;

    /**
     * Поле хранить номер машины.
     */
    private String number;

    /**
     * Конструктор класса Truck.
     * @param number - номер машины.
     */
    public Truck(String number) {
        this.number = number;
    }

    /**
     * Возвращает номер машины.
     * @return - номер машины.
     */
    @Override
    public String number() {
        return this.number;
    }

    /**
     * Возвращает размер машины.
     * @return - размер машины.
     */
    @Override
    public int getSize() {
        return size;
    }
}
