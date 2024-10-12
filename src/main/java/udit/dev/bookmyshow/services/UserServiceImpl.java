package udit.dev.bookmyshow.services;

import org.springframework.stereotype.Service;
import udit.dev.bookmyshow.models.User;
import udit.dev.bookmyshow.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        System.out.println("UserService instantiated");
    }

    @Override
    public User signUp(String name, String email, String password) {
        //First Check if User with the given email is already present in the DB or not.
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()) {
            // redirect to login page
            return optionalUser.get();
        }

        //User is not present in the DB, create the user with the given details and save it in the DB.
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        //Password should be stored in the DB after encryption.
        //For now, we are storing password as it is in the DB, we can use BCryptPasswordEncoder
        // to encode the password.
        user.setPassword(password);

        return userRepository.save(user);
    }
}
