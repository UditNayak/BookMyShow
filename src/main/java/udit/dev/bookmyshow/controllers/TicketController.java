package udit.dev.bookmyshow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import udit.dev.bookmyshow.dtos.BookTicketRequestDto;
import udit.dev.bookmyshow.dtos.BookTicketResponseDto;
import udit.dev.bookmyshow.dtos.ResponseStatus;
import udit.dev.bookmyshow.models.Ticket;
import udit.dev.bookmyshow.services.TicketService;


@Controller
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public BookTicketResponseDto bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) {
        BookTicketResponseDto responseDto = new BookTicketResponseDto();
        try{
            Ticket ticket = ticketService.bookTicket(
                    bookTicketRequestDto.getUserId(),
                    bookTicketRequestDto.getShowSeatIds()
            );
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
