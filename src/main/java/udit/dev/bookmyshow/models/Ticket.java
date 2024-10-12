package udit.dev.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private String ticketNumber;
    private Date timeStamp;

    @ManyToOne
    private User user;

    @OneToMany
    private List<ShowSeat> showSeats;

    private int amount;

    @OneToOne
    private Payment payment;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
}

/*
  1        1
Ticket ---- User => M:1
    M          1

    1           M
Ticket ----- ShowSeat => 1:M
    1           1

    1           1
Ticket ----- Payment => 1:1
    1           1

 */
