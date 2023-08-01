package com.example.nlmessagebot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long chatId;
    private int scenario;
    private int vkId;
    private String token;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "chatid=" + chatId +
                ", scenario=" + scenario +
                ", vk_id=" + vkId +
                ", name=" + name +
                ", token='" + token + '\'' +
                '}';
    }
}
