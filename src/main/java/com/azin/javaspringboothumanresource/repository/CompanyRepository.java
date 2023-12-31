package com.azin.javaspringboothumanresource.repository;

import com.azin.javaspringboothumanresource.model.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAll();

    //JPQL
    //@Query("SELECT c FROM Company c WHERE c.uuid = ?1")
    Collection<Company> findCompanyByUuid(UUID uuid);



    List<Company> findByNameContainsOrderByName(String name, Sort sort);

    //@Query("SELECT e FROM Company e ORDER BY e.fieldOfActivity")
    // List<Company> findByName(Sort name);

}
