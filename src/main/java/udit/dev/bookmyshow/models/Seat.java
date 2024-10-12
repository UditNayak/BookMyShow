package udit.dev.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String name;
    private int rowNum;
    private int colNum;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
