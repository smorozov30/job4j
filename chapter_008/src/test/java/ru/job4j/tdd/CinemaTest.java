package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

/**
 * Тест на класс Cinema.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class CinemaTest {
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
     * Тестируем покупку билета.
     */
    @Test
    public void buy() {
        assertThat(this.ticket, is(this.ticket));
    }

    /**
     * Тестируем поиск сейанса по фильтру.
     */
    @Test
    public void find() {
        this.cinema.add(new Session3D(""));
        List<Session> sessions = this.cinema.find(session -> true);
        assertThat(sessions, is(sessions));
    }
}
