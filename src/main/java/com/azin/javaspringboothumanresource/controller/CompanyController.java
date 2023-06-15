package com.azin.javaspringboothumanresource.controller;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.messages.ErrorMessageException;
import com.azin.javaspringboothumanresource.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Controller
@RequestMapping("Company/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @PostMapping(value = "createCompany")
    public ResponseEntity createCompany(@RequestBody CompanyInput companyInput) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.companyService.createCompany(companyInput));
        } catch (Exception exception) {
            if (exception instanceof ErrorMessageException)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(((ErrorMessageException) exception).getErrorMessage());
            else {
                exception.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("system exception occurred");
            }
        }
    }

    @PutMapping(value = "updateCompany")
    public ResponseEntity updateCompany(@RequestBody CompanyInput companyInput) {

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.companyService.updateCompany(companyInput));
        } catch (Exception exception) {
            if (exception instanceof ErrorMessageException)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(((ErrorMessageException) exception).getErrorMessage());
            else {
                exception.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("system exception occurred");
            }
        }
    }


    @DeleteMapping(value = "deleteCompanyByUuid/{companyUuid}")
    public ResponseEntity deleteCompanyByUuid(@PathVariable String companyUuid) {

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.companyService.deleteCompanyByUuid(companyUuid));
        } catch (Exception exception) {
            if (exception instanceof ErrorMessageException)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(((ErrorMessageException) exception).getErrorMessage());
            else {
                exception.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("system exception occurred");
            }
        }
    }


    @GetMapping(value = "findCompanyByUuid/{companyUuid}")
    public ResponseEntity findCompanyByUuid(@PathVariable String companyUuid) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.companyService.findCompanyByUuid(companyUuid));
        } catch (Exception exception) {

            if (exception instanceof ErrorMessageException)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                        body(((ErrorMessageException) exception).getErrorMessage());
            else {
                exception.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("system exception occurred");
            }
        }
    }

}