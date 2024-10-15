package udit.dev.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import udit.dev.bookmyshow.models.Ticket;

@Getter
@Setter
public class BookTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
