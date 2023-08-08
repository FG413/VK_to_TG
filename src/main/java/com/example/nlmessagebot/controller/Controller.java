package com.example.nlmessagebot.controller;
import com.example.nlmessagebot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.nlmessagebot.repository.UserRepository;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class Controller {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ArrayList<String> getUser(){
        ArrayList<String> list = new ArrayList<>();
       userRepository.findAll().forEach(user -> list.add(user.getName()));
        return list;
    }
}
