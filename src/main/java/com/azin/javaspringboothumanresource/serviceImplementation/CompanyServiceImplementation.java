package com.azin.javaspringboothumanresource.serviceImplementation;


import com.azin.javaspringboothumanresource.input.CompanyInput;
import com.azin.javaspringboothumanresource.model.Company;
import com.azin.javaspringboothumanresource.repository.CompanyRepository;
import com.azin.javaspringboothumanresource.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImplementation implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany() {

       Company company = new Company();//.fromDto(companyInput);

       // company.setName("mojtaba");
       // company.setFamily("ghasemi");

//        if (companyInput.getName() == null) {
//            throw new Exception("name is empty");
//        }
//        if (companyInput.getFamily() == null) {
//            throw new Exception("family is empty");
//        }

        return companyRepository.save(company);
    }

}
