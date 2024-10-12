package udit.dev.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    // This model is for storing the price.

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int price;
}

/*
  1             1
ShowSeatType ----- Show => M:1
    M             1
 */
