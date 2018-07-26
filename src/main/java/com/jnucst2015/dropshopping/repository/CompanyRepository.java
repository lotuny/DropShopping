package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Company findCompanyByUsername(String username);
}
