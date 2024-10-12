package udit.dev.bookmyshow.services;

import udit.dev.bookmyshow.dtos.ResponseStatus;
import udit.dev.bookmyshow.models.User;

public interface UserService {
    User signUp(String name, String email, String password);

    ResponseStatus login(String email, String password);
}
