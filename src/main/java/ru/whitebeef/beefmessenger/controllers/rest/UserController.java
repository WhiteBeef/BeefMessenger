package ru.whitebeef.beefmessenger.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.whitebeef.beefmessenger.dto.RegistrationDataDto;
import ru.whitebeef.beefmessenger.services.UserService;

@RestController("/api")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid RegistrationDataDto registrationDataDto) {
        userService.signUpUser(registrationDataDto);
        return ResponseEntity.ok("Ok");
    }

}
