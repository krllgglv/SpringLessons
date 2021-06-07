package ru.kgogolev.hometask_11.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kgogolev.hometask_11.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/score")
public class DemoController {
    private final UserService userService;

    @GetMapping()
    public String homePage() {
        return "home";
    }

    @GetMapping("/get/{id}")
    public Integer getScoreByUserId(@PathVariable Long id) {
        return userService.findUserScore(id);
    }


    @GetMapping("/inc")
    public Integer incrementScore(Principal principal) {
        return userService.incrementScore(principal);
    }

    @GetMapping("/dec")
    public Integer decrementScore(Principal principal) {
        return userService.decrementScore(principal);
    }
}
