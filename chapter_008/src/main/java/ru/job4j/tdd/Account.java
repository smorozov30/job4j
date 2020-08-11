package ru.job4j.tdd;

import java.util.List;

/**
 * Интерфейс пользователь.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public interface Account {

    /**
     * Возвращает все купленные пользователем билеты.
     * @return - коллекция билетов.
     */
    List<Ticket> tickets();

    /**
     * Добавляет новый билет пользователю.
     * @param ticket - новый билет.
     * @return - результат добавления.
     */
    boolean addTicket(Ticket ticket);

    /**
     * Удаляет билет из коллекции.
     * @param ticket - билет для удаления.
     * @return = результат удаления.
     */
    boolean removeTicket(Ticket ticket);
}
