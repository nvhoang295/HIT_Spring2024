package com.viethoang.week07.repository;

import com.viethoang.week07.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(
            "SELECT c FROM Company c " +
            "WHERE c.name LIKE %:keyword% "
    )
    Page<Company> search(Pageable pageable, String keyword);
}
