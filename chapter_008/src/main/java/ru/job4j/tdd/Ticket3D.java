package ru.job4j.tdd;

import java.util.Date;

/**
 * Класс билет.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Ticket3D implements Ticket {

    public Ticket3D() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Session getSession() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getDate() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRow() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getColumn() {
        return 0;
    }
}
