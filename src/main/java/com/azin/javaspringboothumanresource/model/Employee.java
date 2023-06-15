package com.azin.javaspringboothumanresource.model;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.input.EmployeeInput;
import com.azin.javaspringboothumanresource.output.CompanyOutput;
import com.azin.javaspringboothumanresource.output.EmployeeOutput;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@DiscriminatorValue("1")
@Table(name = "EMPLOYEE")
public class Employee extends Com_User{

    @Column(name = "CONTRACT_TYPE")
    private String contractType;

    @Column(name = "START_CONTRACT_DATE")
    private LocalDate startContractDate;



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

    public EmployeeOutput toDto() {
        EmployeeOutput employeeOutput = new EmployeeOutput(this.getUuid(), this.getName() , this.getFamily()
                                            , this.getContractType() , this.getStartContractDate());
        return employeeOutput;
    }
    public Employee fromDto(EmployeeInput employeeInput) {

        this.setName(employeeInput.getName());
        this.setContractType(employeeInput.getContractType());
        this.setFamily(employeeInput.getFamily());
        this.setUuid(employeeInput.getUuid());
        this.setStartContractDate(employeeInput.getStartContractDate());

        return this;
    }
}
