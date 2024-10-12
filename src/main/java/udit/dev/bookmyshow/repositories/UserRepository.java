package udit.dev.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udit.dev.bookmyshow.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Select * from users where email = email;
    Optional<User> findByEmail(String email);

    // Insert into users (name, email, password) values (name, email, password);
    @Override
    User save(User user);
}
