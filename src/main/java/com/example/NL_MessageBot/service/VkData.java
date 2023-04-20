package com.example.NL_MessageBot.service;
import java.util.List;
import java.util.stream.Collectors;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiAuthException;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.*;
import com.vk.api.sdk.queries.messages.MessagesGetHistoryQuery;
import org.springframework.stereotype.Component;


@Component
public class VkData {
    final public static VkApiClient vk = new VkApiClient(new HttpTransportClient());
    public static String dataReader(UserActor actor) throws ClientException, ApiException {
        MessagesGetHistoryQuery history = vk.messages().getHistory(actor);



            List<Message> oneMessage = history.userId(220965381).count(4).execute().getItems();
            return oneMessage.stream().map(Message::getText).collect(Collectors.toList()).toString();



    }
}
