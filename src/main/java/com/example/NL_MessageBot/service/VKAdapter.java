package com.example.NL_MessageBot.service;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;

public  class VKAdapter {


    public static UserActor getActor() {
        return actor;
    }
    private static UserActor actor;
    private static int id;
    private static String token;
    public VKAdapter(int id, String token) {
        actor= new UserActor(id,token);
        this.id=id;
        this.token=token;
    }
}
