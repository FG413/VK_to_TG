package com.example.nlmessagebot.controller;

import com.example.nlmessagebot.repository.entity.User;
import com.example.nlmessagebot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<String> getUser(){
        return userRepository.findAll().stream().map(User::getName).toList();
    }
}
