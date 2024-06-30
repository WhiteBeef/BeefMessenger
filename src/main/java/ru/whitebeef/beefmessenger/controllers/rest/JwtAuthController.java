package ru.whitebeef.beefmessenger.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.whitebeef.beefmessenger.dto.AuthRequestDto;
import ru.whitebeef.beefmessenger.dto.JwtResponseDTO;
import ru.whitebeef.beefmessenger.services.JwtService;

@RestController
public class JwtAuthController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public JwtAuthController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/api/login")
    public JwtResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDto authRequestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));
        if (!authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("Invalid user request..!!");
        }
        return JwtResponseDTO.builder()
                .accessToken(jwtService.GenerateToken(authRequestDto.getUsername())).build();
    }
}
