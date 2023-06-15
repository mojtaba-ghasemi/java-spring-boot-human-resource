package com.azin.javaspringboothumanresource.service;

import com.azin.javaspringboothumanresource.input.EmployeeInput;
import com.azin.javaspringboothumanresource.output.CompanyOutput;
import com.azin.javaspringboothumanresource.output.EmployeeOutput;

public interface EmployeeService {
    EmployeeOutput createEmployee(EmployeeInput companyInput) throws Exception;
}
