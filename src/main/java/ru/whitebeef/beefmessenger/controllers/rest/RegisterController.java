package ru.whitebeef.beefmessenger.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.whitebeef.beefmessenger.dto.AuthRequestDto;
import ru.whitebeef.beefmessenger.services.UserService;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;


    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody @Valid AuthRequestDto authRequestDto) {
        userService.signUpUser(authRequestDto);
        return ResponseEntity.ok("Ok");
    }


}
