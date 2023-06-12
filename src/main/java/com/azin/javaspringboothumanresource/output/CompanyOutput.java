package com.azin.javaspringboothumanresource.output;

import lombok.Data;

@Data
public class CompanyOutput {

    public CompanyOutput() {
    }
    public CompanyOutput(String name, String family) {
        this.name = name;
        this.family = family;
    }


    private Long id;

    private String name;

    private String family;
}

