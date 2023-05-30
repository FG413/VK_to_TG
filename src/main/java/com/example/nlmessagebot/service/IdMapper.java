package com.example.nlmessagebot.service;

import com.vk.api.sdk.client.actors.UserActor;

import java.util.HashMap;
import java.util.Map;

public class IdMapper {
    public static Map<Long, MapFolder> dataFolder = new HashMap<>();
    public static int getScenario(long id) {return dataFolder.get(id).getScenario();}

    public static int getVkId(long id) {
        return dataFolder.get(id).getVkId();
    }

    public static String getToken(long id) {
        return dataFolder.get(id).getVkAdapter().getActor().getAccessToken();
    }

    public static UserActor getActor(long id) {
        return dataFolder.get(id).getVkAdapter().getActor();
    }

    public static void setNewId(long id) {

        dataFolder.put(id, new MapFolder(0,0,new VKAdapter(0,"vk.q")));
    }

    public static void setNewVkId(long id, int vkId) {
        dataFolder.get(id).setVkId(vkId);
    }

    public static void setNewScenario(long id, int plan) {
        dataFolder.get(id).setScenario(plan);
    }

    public static void setNewToken(long id, String token) {
        dataFolder.get(id).setVkAdapter(new VKAdapter(dataFolder.get(id).getVkId(),token));
    }
}
