package udit.dev.bookmyshow.controllers;

import org.springframework.web.bind.annotation.*;
import udit.dev.bookmyshow.dtos.*;
import udit.dev.bookmyshow.dtos.ResponseStatus;
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

    //http://localhost:8080/users/login
    @GetMapping("/login")
    public LogInResponseDto login(@RequestBody LogInRequestDto logInRequestDto){
        ResponseStatus responseStatus = userService.login(
                logInRequestDto.getEmail(),
                logInRequestDto.getPassword()
        );

        LogInResponseDto logInResponseDto = new LogInResponseDto();
        logInResponseDto.setResponseStatus(responseStatus);

        return logInResponseDto;
    }
}
