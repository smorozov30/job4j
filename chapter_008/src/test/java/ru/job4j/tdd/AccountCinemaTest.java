package ru.job4j.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Тест на класс AccountCinema.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class AccountCinemaTest {
    private Account account;
    private Cinema cinema;
    private Calendar date;
    private Ticket ticket;

    @Before
    public void beforeTests() {
        this.account = new AccountCinema();
        this.cinema = new Cinema3D();
        this.date = Calendar.getInstance();
        this.date.set(2020, 10, 10, 23, 00);
        this.ticket = cinema.buy(account, 1, 1, date);
    }

    /**
     * Тестируем добавление билета в аккаунт пользователя.
     */
    @Test
    public void whenAddTicketReturnTrueAndNotNull() {
        assertTrue(this.account.addTicket(ticket));
        assertNotNull(this.account.tickets());
    }

    /**
     * Тестируем удаление билета из аккаунта пользователя.
     */
    @Test
    public void whenRemoveTicketThanReturnTrue() {
        assertTrue(this.account.addTicket(ticket));
        assertNotNull(this.account.tickets());
        assertTrue(this.account.removeTicket(ticket));
    }
}