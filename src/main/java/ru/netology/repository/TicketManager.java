package ru.netology.repository;

import ru.netology.homework.Ticket;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    protected TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.saveTicket(ticket);
    }

    public void findTicketById(int id) {
        repo.findTicketById(id);
    }

    public void removeTicketById(int id) {
        repo.removeTicketById(id);
    }

    public Ticket[] getSavedTickets() {
        return repo.getSavesTickets();
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                 Ticket[] tmp = new Ticket [result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matches (Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
            return ticket.getTo().contains(to);
        }
        return false;
    }

    public Ticket[] show() {
        Ticket[] result = repo.findAll();
        Arrays.sort(result);
        return result;
    }
}
