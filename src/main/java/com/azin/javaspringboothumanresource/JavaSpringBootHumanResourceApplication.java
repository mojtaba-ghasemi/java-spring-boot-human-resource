package com.azin.javaspringboothumanresource;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.repository.CompanyRepository;
import com.azin.javaspringboothumanresource.serviceImplementation.CompanyServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringBootHumanResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootHumanResourceApplication.class, args);
    }
}
