package udit.dev.bookmyshow.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import udit.dev.bookmyshow.models.*;
import udit.dev.bookmyshow.repositories.ShowSeatRepository;
import udit.dev.bookmyshow.repositories.TicketRepository;
import udit.dev.bookmyshow.repositories.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService{
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(UserRepository userRepository, ShowSeatRepository showSeatRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
    }
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId, List<Long> showSeatIds) {
        /*
        1. Get the user from the database using userId
        2. Get the showSeat Details from the database using showSeatIds
        3. Check if all the seats selected are available
        4. If even one seat is not available, booking cannot be done
        5. If all seats are available, proceed with the booking
        */

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            // redirect the user to the sign up page
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();

        // List can never be null. In the worst case, it will be empty. So no need to used Optional. No chance of NullPointerException.
        // Optional is only for single attributes. For collections, no need to check null.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat: showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("Show Seat not available. Please select another seat");
            }
        }

        // Call Payment Service to Complete the Payment

        for(ShowSeat showSeat: showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatRepository.save(showSeat);
        }

        Ticket ticket = new Ticket();
        ticket.setTicketNumber(UUID.randomUUID().toString());
        ticket.setTicketStatus(TicketStatus.CONFIRMED);
        ticket.setUser(user);
        ticket.setTimeStamp(new Date());
        ticket.setPayment(new Payment());
        ticket.setAmount(1000);
        ticket.setShowSeats(showSeats);

        return ticketRepository.save(ticket);

    }

}
