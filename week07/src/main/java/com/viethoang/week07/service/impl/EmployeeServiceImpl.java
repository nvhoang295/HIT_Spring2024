package com.viethoang.week07.service.impl;

import com.viethoang.week07.dto.CommonResponseDTO;
import com.viethoang.week07.dto.PaginationRequestDTO;
import com.viethoang.week07.dto.PaginationResponseDTO;
import com.viethoang.week07.entity.Company;
import com.viethoang.week07.entity.Employee;
import com.viethoang.week07.repository.CompanyRepository;
import com.viethoang.week07.repository.EmployeeRepository;
import com.viethoang.week07.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository  companyRepository;

    @Override
    public CommonResponseDTO<Employee> getOne(Integer id) {
        return CommonResponseDTO.<Employee>builder()
                                .success(true)
                                .message("Tim thay")
                                .item(employeeRepository.findById(id)
                                                        .orElseThrow(() -> new RuntimeException("Khong tim thay")))
                                .build();
    }

    @Override
    public PaginationResponseDTO<Employee> getList(PaginationRequestDTO request) {
        Sort sort = request.direction().equals("asc") ? Sort.by(request.fields()).ascending()
                                                      : Sort.by(request.fields()).descending();

        Pageable pageable = PageRequest.of(request.index(), request.size(), sort);

        Page<Employee> page = request.q() == null ? employeeRepository.findAll(pageable)
                                                  : employeeRepository.search(pageable, request.q());

        return PaginationResponseDTO.<Employee>builder()
                                    .keyword(request.q())
                                    .pageIndex(request.index())
                                    .pageSize(page.getSize())
                                    .totalItems(page.getTotalElements())
                                    .totalPages(page.getTotalPages())
                                    .items(page.getContent())
                                    .build();
    }

    @Override
    public CommonResponseDTO<?> addOne(Integer companyId, Employee employee) {
        Optional<Company> foundCompany = companyRepository.findById(companyId);

        if (foundCompany.isEmpty())
            throw new RuntimeException("Khong tim thay");

        employee.setCompany(foundCompany.get());
        employeeRepository.save(employee);

        return CommonResponseDTO.builder()
                                .success(true)
                                .message("Them thanh cong!")
                                .build();
    }

    @Override
    public CommonResponseDTO<Employee> updateOne(Integer companyId, Integer employeeId, Employee employee) {
        Optional<Employee> found = employeeRepository.findById(employeeId);
        if (found.isEmpty())
            throw new RuntimeException("Khong tim thay");
        found.get().setName(employee.getName());
        return CommonResponseDTO.<Employee>builder()
                                .success(true)
                                .message("Them thanh cong!")
                                .item(employeeRepository.save(found.get()))
                                .build();
    }

    @Override
    public CommonResponseDTO<?> deleteOne(Integer companyId, Integer employeeId) {
        return null;
    }

    @Override
    public PaginationResponseDTO<Employee> getListByCompany(Integer companyId, PaginationRequestDTO request) {
        return null;
    }
}
