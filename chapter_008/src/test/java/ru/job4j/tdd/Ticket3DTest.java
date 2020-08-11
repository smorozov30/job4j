package ru.job4j.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тест на класс Ticket3D.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Ticket3DTest {

    /**
     * Тестируем создание билета.
     */
    @Test
    public void whenCreateNewTicketReturnData() {
        Ticket ticket = new Ticket3D();
        assertNull(ticket.getSession());
        assertNull(ticket.getDate());
    }
}