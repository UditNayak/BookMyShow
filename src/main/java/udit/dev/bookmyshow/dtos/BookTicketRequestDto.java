package udit.dev.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private Long userId;
    private Long showId;  // Not required
    private List<Long> showSeatIds;
}
