package udit.dev.bookmyshow.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udit.dev.bookmyshow.dtos.ResponseStatus;
import udit.dev.bookmyshow.dtos.SignUpRequestDto;
import udit.dev.bookmyshow.dtos.SignUpResponseDto;
import udit.dev.bookmyshow.models.User;
import udit.dev.bookmyshow.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        System.out.println("UserController instantiated");
    }

    //http://localhost:8080/users/signup
    @PostMapping("/signup")
    public SignUpResponseDto signup(@RequestBody SignUpRequestDto signUpRequestDto) {
        User user = userService.signUp(
                signUpRequestDto.getName(),
                signUpRequestDto.getEmail(),
                signUpRequestDto.getPassword()
        );

        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        signUpResponseDto.setId(user.getId());
        signUpResponseDto.setEmail(user.getEmail());
        signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        return signUpResponseDto;
    }
}
