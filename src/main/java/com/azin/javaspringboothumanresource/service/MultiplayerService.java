package com.azin.javaspringboothumanresource.service;

public class MultiplayerService {

    private final int multiplayer;

    public MultiplayerService(int multiplayer) {
        this.multiplayer = multiplayer;
    }

    public int multiplay(int value) {
        return value * multiplayer;
    }

    public void init() {
        System.out.println("Calling init method");
    }

    public void destroyMethod() {
        System.out.println("Calling destroy method");
    }
}
