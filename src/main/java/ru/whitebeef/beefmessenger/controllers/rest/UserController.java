package ru.whitebeef.beefmessenger.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.whitebeef.beefmessenger.dto.LoginDataDto;
import ru.whitebeef.beefmessenger.services.UserService;

@RestController()
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody @Valid LoginDataDto loginDataDto) {
        userService.signUpUser(loginDataDto);
        return ResponseEntity.ok("Ok");
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDataDto loginDataDto) {
        userService.loginUser(loginDataDto);
        return ResponseEntity.ok("Ok");
    }

}
