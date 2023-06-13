package com.azin.javaspringboothumanresource.input;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CompanyInput {

    private Long id;
    private String name;

    private String fieldOfActivity;

    private LocalDate startActivityDate;

    private UUID uuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getFieldOfActivity() {
        return fieldOfActivity;
    }

    public void setFieldOfActivity(String family) {
        this.fieldOfActivity = family;
    }

    public LocalDate getStartActivityDate() {
        return startActivityDate;
    }

    public void setStartActivityDate(LocalDate startActivityDate) {
        this.startActivityDate = startActivityDate;
    }



}
