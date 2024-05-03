package com.viethoang.week07.service;

import com.viethoang.week07.dto.CommonResponseDTO;
import com.viethoang.week07.dto.PaginationRequestDTO;
import com.viethoang.week07.dto.PaginationResponseDTO;
import com.viethoang.week07.entity.Employee;

public interface EmployeeService {
    CommonResponseDTO<Employee> getOne(Integer id);
    PaginationResponseDTO<Employee> getList(PaginationRequestDTO request);
    CommonResponseDTO<?> addOne(Integer companyId, Employee employee);
    CommonResponseDTO<Employee> updateOne(Integer companyId, Integer employeeId, Employee employee);
    CommonResponseDTO<?> deleteOne(Integer companyId, Integer employeeId);
    PaginationResponseDTO<Employee> getListByCompany(Integer companyId, PaginationRequestDTO request);
}
