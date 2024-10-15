package udit.dev.bookmyshow.services;

import udit.dev.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(Long userId, List<Long> showSeatIds);
}
