package ru.job4j.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс пользователь.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class AccountCinema implements Account {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ticket> tickets() {
        return new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addTicket(Ticket ticket) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeTicket(Ticket ticket) {
        return true;
    }
}
