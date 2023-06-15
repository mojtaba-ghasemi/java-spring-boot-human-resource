package com.azin.javaspringboothumanresource.controller;


import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.input.EmployeeInput;
import com.azin.javaspringboothumanresource.messages.ErrorMessageException;
import com.azin.javaspringboothumanresource.service.CompanyService;
import com.azin.javaspringboothumanresource.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("Employee/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping(value = "createEmployee")
    public ResponseEntity createCompany(@RequestBody EmployeeInput employeeInput) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.employeeService.createEmployee(employeeInput));
        } catch (Exception exception) {
            if (exception instanceof ErrorMessageException)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(((ErrorMessageException) exception).getErrorMessage());
            else {
                exception.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("system exception occurred");
            }
        }
    }

}
