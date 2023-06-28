package com.azin.javaspringboothumanresource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private final MultiplayerService multiplayerService;


//    public AppService(@Autowired @Qualifier("mojtaba") MultiplayerService multiplayerService){
//
//        this.multiplayerService = multiplayerService;
//    }

    public AppService(MultiplayerService multiplayerService){

        this.multiplayerService = multiplayerService;
    }

    public int calculate(int aValue){
        return multiplayerService.multiplay(aValue);
    }
}
