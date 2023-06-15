package com.azin.javaspringboothumanresource.input;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeInput {


    private UUID uuid;
    private String name;
    private String family;
    private String contractType;
    private LocalDate startContractDate;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public LocalDate getStartContractDate() {
        return startContractDate;
    }

    public void setStartContractDate(LocalDate startContractDate) {
        this.startContractDate = startContractDate;
    }



}
