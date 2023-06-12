package com.azin.javaspringboothumanresource.model;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.output.CompanyOutput;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FAMILY")
    private String family;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        family = family;
    }


    public CompanyOutput toDto() {
        CompanyOutput companyOutput = new CompanyOutput();
        companyOutput.setName(name);
        companyOutput.setFamily(family);
        return companyOutput;
    }

    public Company fromDto(CompanyInput companyInput) {

        Company company = new Company();
        company.setName(companyInput.getName());
        company.setFamily(companyInput.getFamily());

        return company;
    }

}
