package com.azin.javaspringboothumanresource.repository;

import com.azin.javaspringboothumanresource.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAll();
}
