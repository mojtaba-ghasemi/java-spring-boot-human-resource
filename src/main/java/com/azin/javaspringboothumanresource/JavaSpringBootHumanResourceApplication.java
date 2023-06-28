package com.azin.javaspringboothumanresource;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.repository.CompanyRepository;
import com.azin.javaspringboothumanresource.service.AppService;
import com.azin.javaspringboothumanresource.serviceImplementation.CompanyServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JavaSpringBootHumanResourceApplication {



    private final AppService appService;

    public JavaSpringBootHumanResourceApplication(AppService appService) {
        this.appService = appService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootHumanResourceApplication.class, args);
    }

    @PostConstruct
    public void doExample(){
       // System.out.println("Calling been with it result " + appService.calculate(4));
    }
}
