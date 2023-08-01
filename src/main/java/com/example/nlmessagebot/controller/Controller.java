package com.example.nlmessagebot.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.nlmessagebot.model.User;
import com.example.nlmessagebot.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class Controller {
    private UserRepository userRepository;
    long x = 1491058767;
    @GetMapping
    public User getUser(){
        return new User(x,123,123,"1qe","qwe");
    }
}
