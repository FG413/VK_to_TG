package com.example.nlmessagebot.service;

import java.util.ArrayList;
import java.util.List;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.*;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VkData {
    final public static VkApiClient vk = new VkApiClient(new HttpTransportClient());
    public static List<MessageData> sumOfList = new ArrayList<>();
    public static List<String> globalListOfText = new ArrayList<>();
    public static List<String> globalListOfName = new ArrayList<>();

    public static List<Integer> globalListOfDate = new ArrayList<>();

    public static void dataReader(UserActor actor) throws ApiException{
        try {



        List<Integer> conId = vk.messages().
                getConversations(actor).
                execute().
                getItems().
                stream().
                map(ConversationWithMessage::getConversation).
                map(Conversation::getPeer).
                map(ConversationPeer::getId).
                toList();
        List<Integer> ConUnread = vk.messages().
                getConversations(actor).
                execute().
                getItems().
                stream().
                map(ConversationWithMessage::getConversation).
                map(Conversation::getUnreadCount).
                toList();


        for (int count = 0; count < 20; count++) {
            if (ConUnread.get(count) != null) {
                globalListOfText.addAll(vk.messages().
                        getHistory(actor).
                        userId(conId.get(count)).
                        count(ConUnread.get(count)).
                        execute().
                        getItems().
                        stream().
                        map(Message::getText).
                        toList());

                List<Integer> listOfId = vk.messages().
                        getHistory(actor).
                        userId(conId.get(count)).
                        count(ConUnread.get(count)).
                        execute().
                        getItems().
                        stream().
                        map(Message::getFromId).
                        toList();

                globalListOfDate.addAll(vk.messages().
                        getHistory(actor).
                        userId(conId.get(count)).
                        count(ConUnread.get(count)).
                        execute().
                        getItems().
                        stream().
                        map(Message::getDate).toList());
                for (int count1 = 0; count1 < listOfId.size(); count1++) {
                    GetResponse response = vk.users().get(actor).userIds(listOfId.get(count).toString()).execute().get(0);
                    globalListOfName.add(response.getFirstName() +
                            " " +
                            response.getLastName());

                }
            }
        }
        for (int count = 0; count < globalListOfDate.size(); count++) {

            sumOfList.add(new MessageData(globalListOfText.get(count), globalListOfName.get(count), globalListOfDate.get(count)));
        }
    }
        catch ( ClientException e){
            log.error("Error occured:" + e.getMessage());
        }
        }
        public static void dataCleaner () {
            globalListOfName.clear();
            globalListOfText.clear();
            globalListOfDate.clear();
            sumOfList.clear();
        }
    }
