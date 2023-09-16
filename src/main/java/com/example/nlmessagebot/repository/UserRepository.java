package com.example.nlmessagebot.repository;

import com.example.nlmessagebot.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
