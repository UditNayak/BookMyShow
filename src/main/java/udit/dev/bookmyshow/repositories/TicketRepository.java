package udit.dev.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udit.dev.bookmyshow.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Override
    Ticket save(Ticket ticket);
}
