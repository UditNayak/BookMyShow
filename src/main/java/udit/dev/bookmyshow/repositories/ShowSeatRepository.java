package udit.dev.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udit.dev.bookmyshow.models.ShowSeat;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

}
