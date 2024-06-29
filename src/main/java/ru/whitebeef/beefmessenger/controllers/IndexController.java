package ru.whitebeef.beefmessenger.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.whitebeef.beefmessenger.services.UserService;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;

    @GetMapping("/")
    public String getIndex(Authentication authentication, Model model) {
        model.addAttribute(userService.getUser(authentication.getName()));
        return "index";
    }

}
