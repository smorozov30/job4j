package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Интерфейс кинотеатра.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public interface Cinema {

    /**
     * Возвращает сеансы в кино по фильтру.
     * @param filter - фильтр для выборки сеансов.
     * @return
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * Возвращает купленый билет.
     * @param account - аккаунт пользователя.
     * @param row - ряд в зале.
     * @param column - место в зале.
     * @param date - дата и время сеанса.
     * @return - билет на сеанс.
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * Добавляет сеанс кино в список.
     * @param session - новый сеанс.
     */
    void add(Session session);
}
