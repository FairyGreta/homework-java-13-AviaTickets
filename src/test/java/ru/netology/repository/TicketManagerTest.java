package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.reporting.ReportEntry;
import ru.netology.homework.Ticket;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 5800, "ABA", "SCO", 120);
    Ticket ticket2 = new Ticket(2, 5100, "AKX", "GZP", 121);
    Ticket ticket3 = new Ticket(3, 5200, "ALA", "DYR", 122);
    Ticket ticket4 = new Ticket(4, 5900, "ABA", "SCO", 180);

    @BeforeEach
    public void shouldSetAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    public void shouldRemoveById() {
        manager.removeTicketById(ticket2.getId());

        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket4};
        Ticket[] actual = manager.getSavedTickets();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketFromTo() {
        Ticket[] expected = new Ticket[] {ticket1, ticket4};
        Ticket[] actual = manager.findAll("ABA", "SCO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketFromToNot() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("SVO", "ABA");

        assertArrayEquals(expected, actual);
    }

    

//    @Test
//    public void shouldFindTicketFromTo() {
//        Ticket[] expected = new Ticket[] {ticket2};
//        Ticket[] actual = manager.findAll("AKX", "GZP");
//
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldNotFindTicketFromTo() {
//        Ticket[] expected = new Ticket[0];
//        Ticket[] actual = manager.findAll("AKX", "ABA");
//
//        assertArrayEquals(expected, actual);
//    }
}
