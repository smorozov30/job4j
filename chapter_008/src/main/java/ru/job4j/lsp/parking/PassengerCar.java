package ru.job4j.lsp.parking;

/**
 * Класс представляющий легковой автомобиль.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class PassengerCar implements Car {

    /**
     * Поле хранит размер машины.
     */
    private static int size = 1;

    /**
     * Поле хранить номер машины.
     */
    private String number;

    /**
     * Конструктор класса PassengerCar.
     * @param number - номер машины.
     */
    public PassengerCar(String number) {
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
