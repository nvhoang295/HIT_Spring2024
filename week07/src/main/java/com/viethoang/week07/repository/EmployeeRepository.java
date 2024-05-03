package com.viethoang.week07.repository;

import com.viethoang.week07.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(
            "SELECT c FROM Employee c " +
            "WHERE c.name LIKE %:keyword% "
    )
    Page<Employee> search(Pageable pageable, String keyword);
}
