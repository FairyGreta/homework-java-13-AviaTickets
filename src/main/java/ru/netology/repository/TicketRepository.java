package ru.netology.repository;

import ru.netology.homework.Ticket;

public class TicketRepository {

    /* репозиторий должен
    сохранять билет
    показывать все билеты
    удалять по id
     */
    protected Ticket[] tickets = new Ticket[0];

    public void saveTicket (Ticket newTicket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = newTicket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeTicketById(int id) {
        if (findTicketById(id) == null) {throw new NotFoundException(
                "Билет с Id " + id + " не найден"
        );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] getSavesTickets() {
        return tickets;
    }
}
