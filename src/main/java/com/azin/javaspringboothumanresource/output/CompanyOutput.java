package com.azin.javaspringboothumanresource.output;

import com.azin.javaspringboothumanresource.model.Company;
import lombok.Data;


import java.time.LocalDate;

import java.util.UUID;

@Data
public class CompanyOutput {

    public CompanyOutput() {
    }

    public CompanyOutput(String name, String fieldOfActivity, UUID uuid, LocalDate startActivityDate) {
        this.uuid = uuid;
        this.name = name;
        this.fieldOfActivity = fieldOfActivity;
        this.startActivityDate = startActivityDate;
    }

    public CompanyOutput(Company company) {
        this.uuid = company.getUuid();
        this.name = company.getName();
        this.fieldOfActivity = company.getFieldOfActivity();
        this.startActivityDate = company.getStartActivityDate();
    }

    private UUID uuid;
    private String name;
    private String fieldOfActivity;
    private LocalDate startActivityDate;
}

