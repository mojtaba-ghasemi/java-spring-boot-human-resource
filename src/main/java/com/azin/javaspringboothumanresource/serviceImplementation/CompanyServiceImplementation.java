package com.azin.javaspringboothumanresource.serviceImplementation;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.messages.ErrorMessageException;
import com.azin.javaspringboothumanresource.model.Company;
import com.azin.javaspringboothumanresource.output.CompanyOutput;
import com.azin.javaspringboothumanresource.repository.CompanyRepository;
import com.azin.javaspringboothumanresource.service.CompanyService;
import com.azin.javaspringboothumanresource.service.SpringBeanService.CRUDControllerService;
import com.azin.javaspringboothumanresource.utility.logmanagement.logenum.LogDirection;
import com.azin.javaspringboothumanresource.utility.logmanagement.serviceImplimentation.LogServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImplementation implements CompanyService {


    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private LogServiceImplementation logServiceImplementation;

    @Autowired
    private CRUDControllerService crudControllerService;

    @Override
    public CompanyOutput createCompany(CompanyInput companyInput) throws Exception {

        UUID logUuid = logServiceImplementation.createServiceStartLog("createCompany", companyInput, true, true);

        try {
            if (companyInput.getName() != null && companyInput.getFieldOfActivity() != null) {
                Company company = new Company().fromDto(companyInput);
                company.setUuid(UUID.randomUUID());

                company = companyRepository.save(company);
                logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, company);

                return company.toDto();
            } else
                throw new ErrorMessageException(0, 100, "NameOrFieldOfActivityEmpty");

        } catch (Exception exception) {
            logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, "", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public CompanyOutput updateCompany(CompanyInput companyInput) throws Exception {

        UUID logUuid = logServiceImplementation.createServiceStartLog("updateCompany", companyInput, true, true);

        try {

            if (companyInput.getName() != null && companyInput.getFieldOfActivity() != null) {
                Company company = findCompanyModelByUuid(companyInput.getUuid());
                company = companyRepository.save(company.fromDto(companyInput));

                logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, company);

                return company.toDto();
            } else throw new ErrorMessageException(0, 100, "NameOrFieldOfActivityEmpty");
        } catch (Exception exception) {
            logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, "", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public CompanyOutput findCompanyByUuid(String companyUuid) throws Exception {

        UUID logUuid = logServiceImplementation.createServiceStartLog("findCompanyByUuid", companyUuid, true, true);

        try {
            CompanyOutput companyOutput = new CompanyOutput(findCompanyModelByUuid(UUID.fromString(companyUuid)));
            logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, companyOutput);
            return companyOutput;
        } catch (Exception exception) {
            logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, "", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public boolean deleteCompanyByUuid(String companyUuid) throws Exception {

        crudControllerService.checkDelete();
        
        UUID logUuid = logServiceImplementation.createServiceStartLog("deleteCompanyByUuid", companyUuid, true, true);

        try {
            companyRepository.delete(findCompanyModelByUuid(UUID.fromString(companyUuid)));
            logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, "", "");
            return true;
        } catch (Exception exception) {
            logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, "", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public List<CompanyOutput> findByName(String name) {
        try {
            List<CompanyOutput> result = new ArrayList<>();

            List<Company> companyCollation = companyRepository
                    .findByNameContainsOrderByName(name, Sort.by("fieldOfActivity"));

            for (Company company : companyCollation) {
                result.add(new CompanyOutput(company));
            }
            return result;
        } catch (Exception exception) {
            throw exception;
        }
    }


    private Company findCompanyModelByUuid(UUID uuid) throws Exception {

        try {
            Collection<Company> companyCollation = companyRepository.findCompanyByUuid(uuid);
            if (companyCollation.size() == 1) return companyCollation.iterator().next();
            else if (companyCollation.size() == 0) throw new ErrorMessageException(0, 102, "CompanyUUIDNotExist");
            else throw new Exception("system exception occurred");

        } catch (Exception exception) {
            throw exception;
        }
    }

//    @Override
//    public List<CompanyOutput> getCompanies() throws Exception {
//
//    }
}
