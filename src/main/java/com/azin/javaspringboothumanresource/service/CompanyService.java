package com.azin.javaspringboothumanresource.service;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.output.CompanyOutput;

public interface CompanyService {

    CompanyOutput createCompany(CompanyInput companyInput) throws Exception;

    CompanyOutput updateCompany(CompanyInput companyInput) throws Exception;

    CompanyOutput findCompanyByUuid(CompanyInput companyInput) throws Exception;

    boolean deleteCompanyByUuid(CompanyInput companyInput) throws Exception;
}
