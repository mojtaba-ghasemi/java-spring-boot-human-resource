package com.azin.javaspringboothumanresource;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.serviceImplementation.CompanyServiceImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringBootHumanResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootHumanResourceApplication.class, args);

        CompanyServiceImplementation companyServiceImplementation = new CompanyServiceImplementation();

        CompanyInput companyInput = new CompanyInput();
        companyInput.setName("mojtaba");
        companyInput.setFamily("ghasemi");

        companyServiceImplementation.createCompany();
    }
}
