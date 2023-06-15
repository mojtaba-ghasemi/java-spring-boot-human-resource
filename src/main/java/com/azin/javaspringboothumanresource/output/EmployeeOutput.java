package com.azin.javaspringboothumanresource.output;

import com.azin.javaspringboothumanresource.model.Company;
import com.azin.javaspringboothumanresource.model.Employee;

import java.time.LocalDate;
import java.util.UUID;

public class EmployeeOutput {

    public EmployeeOutput() {
    }

    public EmployeeOutput(UUID uuid, String name, String family, String contractType, LocalDate startContractDate) {
        this.uuid = uuid;
        this.name = name;
        this.family = family;
        this.contractType = contractType;
        this.startContractDate = startContractDate;
    }

    public EmployeeOutput(Employee employee) {
        this.uuid = employee.getUuid();
        this.name = employee.getName();
        this.family = employee.getFamily();
        this.contractType = employee.getContractType();
        this.startContractDate = employee.getStartContractDate();
    }

    private UUID uuid;
    private String name;
    private String family;
    private String contractType;
    private LocalDate startContractDate;


}
