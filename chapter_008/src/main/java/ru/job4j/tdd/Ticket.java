package ru.job4j.tdd;

import java.util.Date;

/**
 * Интерфейс билет.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public interface Ticket {

    /**
     * Возращает сеанс на который куплен билет.
     * @return
     */
    Session getSession();

    /**
     * Возращает дату сеанса на который куплен билет.
     * @return
     */
    Date getDate();

    /**
     * Возвращает ряд.
     * @return
     */
    int getRow();

    /**
     * Возвращает место.
     * @return
     */
    int getColumn();
}
