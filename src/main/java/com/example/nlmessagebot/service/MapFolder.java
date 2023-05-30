package com.example.nlmessagebot.service;

public class MapFolder {


    private int scenario;


    private int vkId;

    public void setVkAdapter(VKAdapter vkAdapter) {
        this.vkAdapter = vkAdapter;
    }

    private VKAdapter vkAdapter;

    public VKAdapter getVkAdapter() {
        return vkAdapter;
    }

    public int getVkId() {
        return vkId;
    }
    public void setVkId(int vkId) {
        this.vkId = vkId;
    }

    public int getScenario() {
        return scenario;
    }
    public void setScenario(int scenario) {
        this.scenario = scenario;
    }
    public MapFolder(int scenario, int vkId, VKAdapter vkAdapter){
        this.scenario=scenario;
        this.vkAdapter=vkAdapter;
        this.vkId=vkId;
 }


}
