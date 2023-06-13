package com.azin.javaspringboothumanresource.serviceImplementation;

import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.messages.ErrorMessageException;
import com.azin.javaspringboothumanresource.model.Company;
import com.azin.javaspringboothumanresource.output.CompanyOutput;
import com.azin.javaspringboothumanresource.repository.CompanyRepository;
import com.azin.javaspringboothumanresource.service.CompanyService;
import com.azin.javaspringboothumanresource.utility.logmanagement.LogDirection;
import com.azin.javaspringboothumanresource.utility.logmanagement.LogServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class CompanyServiceImplementation implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private LogServiceImplementation logServiceImplementation;

    @Override
    public CompanyOutput createCompany(CompanyInput companyInput) throws Exception {

        UUID logUuid = UUID.randomUUID();
        logServiceImplementation.createDebugLog("createCompany", "", logUuid, LogDirection.START
                , companyInput);

        try {
            if (companyInput.getName() != null && companyInput.getFieldOfActivity() != null) {
                Company company = new Company().fromDto(companyInput);
                company.setUuid(UUID.randomUUID());

                company = companyRepository.save(company);
                logServiceImplementation.createDebugLog("createCompany", "", logUuid, LogDirection.FINISH
                        , company);

                return company.toDto();
            } else
                throw new ErrorMessageException(0, 100, "NameOrFamilyEmpty");

        } catch (Exception exception) {
            logServiceImplementation.createDebugLog("createCompany", "", logUuid, LogDirection.FINISH
                    , "", exception.getMessage());
            throw exception;
        }
    }

    @Override
    public CompanyOutput updateCompany(CompanyInput companyInput) throws Exception {
        try {

            if (companyInput.getName() != null && companyInput.getFieldOfActivity() != null) {
                Company company = findCompanyModelByUuid(companyInput.getUuid());
                return companyRepository.save(company.fromDto(companyInput)).toDto();
            } else throw new ErrorMessageException(0, 100, "NameOrFamilyEmpty");
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public CompanyOutput findCompanyByUuid(CompanyInput companyInput) throws Exception {
        return new CompanyOutput(findCompanyModelByUuid(companyInput.getUuid()));
    }

    @Override
    public boolean deleteCompanyByUuid(CompanyInput companyInput) throws Exception {
        companyRepository.delete(findCompanyModelByUuid(companyInput.getUuid()));
        return true;
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
}
