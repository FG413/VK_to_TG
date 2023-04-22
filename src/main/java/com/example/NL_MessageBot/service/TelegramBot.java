package com.example.NL_MessageBot.service;

import com.example.NL_MessageBot.config.BotConfig;
import com.vk.api.sdk.exceptions.ApiAuthException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.lang.String;
import java.util.Arrays;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    Message message = new Message();
    private final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
        List<BotCommand> listofCommands = Arrays.asList(new BotCommand("/get_messages", "send last 4 messages"), new BotCommand("/get_mydata", "send actual id and token"), new BotCommand("/set_id", "allow to set new id"), new BotCommand("set_token", "allow to set new token"));
        try {
            this.execute(new SetMyCommands(listofCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    int scenario = 0;
    long chatId;
    VKAdapter Adapter = new VKAdapter(220965381, "vk.afasafsfasgsasadfasdfasfasf");

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText() && (scenario == 0)) {
            String messageText = update.getMessage().getText();
            chatId = update.getMessage().getChatId();
            switch (messageText) {
                case "/get_messages":
                    try {
                        sendMessage(chatId, VkData.dataReader(Adapter.getActor()));
                    } catch (ApiAuthException e) {
                        sendMessage(chatId, "произошла ошибка, пожалуйста введите  новые id и/или токен");
                    }
                    break;
                case "/set_token":
                    sendMessage(chatId, "Пожалуйста установите новый токен");
                    scenario = 1;
                    break;
                case "/set_id":
                    sendMessage(chatId, "Пожалуйста установите новый id");
                    scenario = 2;
                    break;
                case "/get_mydata":
                    sendMessage(chatId, Adapter.getActor().getAccessToken() + "\n" + Adapter.getActor().getId());
                    break;
                default:
                    sendMessage(chatId, "sorry");
            }
        } else if (update.hasMessage() && update.getMessage().hasText() && scenario == 1) {
            Adapter = new VKAdapter(Adapter.getActor().getId(), update.getMessage().getText());
            scenario = 0;
        } else if (update.hasMessage() && update.getMessage().hasText() && scenario == 2) {
            try {
                Adapter = new VKAdapter(Integer.parseInt(update.getMessage().getText()), Adapter.getActor().getAccessToken());
            } catch (NumberFormatException e) {
                sendMessage(chatId, "Некорректный ввод");
            }
            scenario = 0;
        }
    }

    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    public void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
