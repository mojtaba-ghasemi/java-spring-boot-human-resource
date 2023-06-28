package com.azin.javaspringboothumanresource.service;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.model.Company;
import com.azin.javaspringboothumanresource.output.CompanyOutput;

import java.util.List;

public interface CompanyService {

    CompanyOutput createCompany(CompanyInput companyInput) throws Exception;

    CompanyOutput updateCompany(CompanyInput companyInput) throws Exception;

    CompanyOutput findCompanyByUuid(String companyUuid) throws Exception;

    boolean deleteCompanyByUuid(String companyUuid) throws Exception;

    List<CompanyOutput> findByName(String name);


}
