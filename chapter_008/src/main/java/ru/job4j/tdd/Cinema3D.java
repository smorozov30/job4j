package ru.job4j.tdd;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс описывающий кинотеатр.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Cinema3D implements Cinema {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return Arrays.asList(new Session3D(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Session session) {

    }
}
