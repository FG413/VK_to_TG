package com.example.nlmessagebot.controller;
import com.example.nlmessagebot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.nlmessagebot.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<String> getUser(){
        return userRepository.findAll().stream().map(User::getName).toList();
    }
}
