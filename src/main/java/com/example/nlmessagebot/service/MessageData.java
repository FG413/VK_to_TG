package com.example.nlmessagebot.service;

import com.vk.api.sdk.objects.photos.Photo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class MessageData {

    private final String text;

    private final String name;

    private final int date;

}
