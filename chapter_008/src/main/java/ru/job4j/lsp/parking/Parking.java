package ru.job4j.lsp.parking;

/**
 * Интерфейс для классов реализующих поведение парковки.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public interface Parking {

    /**
     * Метод помещает машину на парковочное место.
     * @param car - машина.
     * @return - результат размещения машины.
     */
    boolean park(Car car);

    /**
     * Проверяет возможно ли разместить мащину на парковке.
     * @param car - машина.
     * @return - номер парковочного места, если имеется, иначе -1.
     */
    boolean canPark(Car car);

    /**
     * Удаляет машину с парковки.
     * @param number - номер машины.
     * @return - результат удаления.
     */
    boolean leave(String number);
}
