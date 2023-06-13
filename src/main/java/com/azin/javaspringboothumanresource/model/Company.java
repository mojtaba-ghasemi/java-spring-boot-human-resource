package com.azin.javaspringboothumanresource.model;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.output.CompanyOutput;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;



    @Column(name = "UUID", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID uuid;


    @Column(name = "NAME")
    private String name;

    @Column(name = "FIELD_OF_ACTIVITY")
    private String fieldOfActivity;


    @Column(name = "Start_Activity_Date")
    private LocalDate startActivityDate;


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

    public CompanyOutput toDto() {
        CompanyOutput companyOutput = new CompanyOutput(getName(), getFieldOfActivity(), getUuid(), getStartActivityDate());
        return companyOutput;
    }

    public Company fromDto(CompanyInput companyInput) {

     //   Company company = new Company();
        this.setName(companyInput.getName());
        this.setFieldOfActivity(companyInput.getFieldOfActivity());
        this.setStartActivityDate(companyInput.getStartActivityDate());

        return this;
    }

}
