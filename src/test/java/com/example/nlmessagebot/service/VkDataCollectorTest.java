package com.example.nlmessagebot.service;

import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VkDataCollectorTest {
    @Test
    void acessTokenTest() throws ClientException, ApiException {
        UserActor actor = new UserActor(220965381,"vk1.a.lSdJ1UF1TEZGhOaeIGphE6cXs-6SHvQGiTb99pXb8yyTM1pvTCnnGTtt2MU7cXcA2kOzUbzsc_NjGUBCzbZnTGUPpb8XT6thC7EDH0n3MK1dYO0WKZ3fAxTXkns-vXy8J8e9-h-sO4mLGk4RWv1GLi852EWGJAI17B132t5WIjCD77Z30DWdtDdVbTjNih0Do9-BgoblqtKeFHWdyj1FEw");
        assertNotNull(VkDataCollector.getUnreadMessages(actor));
    }

}