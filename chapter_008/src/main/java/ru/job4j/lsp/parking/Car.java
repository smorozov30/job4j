package ru.job4j.lsp.parking;

/**
 * Интерфейс для классов реализующих поведение машины.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public interface Car {

    /**
     * Возвращает номер машины в виде строки.
     * @return
     */
    String number();

    /**
     * Возвращает размер машины в виде числа.
     * @return
     */
    int getSize();
}
