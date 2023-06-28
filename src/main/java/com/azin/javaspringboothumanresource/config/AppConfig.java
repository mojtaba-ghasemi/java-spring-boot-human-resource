package com.azin.javaspringboothumanresource.config;

import com.azin.javaspringboothumanresource.service.MultiplayerService;
import com.azin.javaspringboothumanresource.service.SpringBeanService.CRUDControllerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean(name = {"mojtaba", "multiplayerService2"}, initMethod = "init", destroyMethod = "destroyMethod")
    public MultiplayerService multiplayer() {
        return new MultiplayerService(3);
    }

    @Bean(name = {"CRUDController"}, initMethod = "init", destroyMethod = "destroyMethod")
    public CRUDControllerService crudControllerService() {
        return new CRUDControllerService();
    }
}
