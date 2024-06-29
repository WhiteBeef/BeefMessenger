package ru.whitebeef.beefmessenger.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.whitebeef.beefmessenger.dto.JwtResponseDTO;
import ru.whitebeef.beefmessenger.dto.LoginDataDto;
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

    /**
     * Authenticates the user and returns a JWT token if successful.
     *
     * @param loginDataDto the user's authentication request
     * @return a JWT response containing the access token
     */
    @PostMapping("/api/login")
    public JwtResponseDTO AuthenticateAndGetToken(@RequestBody LoginDataDto loginDataDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDataDto.getUsername(), loginDataDto.getPassword()));
        if (authentication.isAuthenticated()) {
            return JwtResponseDTO.builder()
                    .accessToken(jwtService.GenerateToken(loginDataDto.getUsername())).build();
        } else {
            throw new UsernameNotFoundException("Invalid user request..!!");
        }
    }
}
