package ru.job4j.poly;

/**
 * Интерфейс транспорт.
 *
 * @author Sergey Morozov(moroz.future@gmail.com)
 * @version 1.0
 */
public interface Transport {
    void drive();
    void passengers(int number);
    double fill(int gas);
}
