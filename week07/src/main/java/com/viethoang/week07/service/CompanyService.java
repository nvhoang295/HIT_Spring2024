package com.viethoang.week07.service;

import com.viethoang.week07.dto.CommonResponseDTO;
import com.viethoang.week07.dto.PaginationRequestDTO;
import com.viethoang.week07.dto.PaginationResponseDTO;
import com.viethoang.week07.entity.Company;

public interface CompanyService {
    CommonResponseDTO<Company> getOne(Integer id);
    PaginationResponseDTO<Company> getList(PaginationRequestDTO request);
    CommonResponseDTO<Company> addOne(Company company);
    CommonResponseDTO<Company> updateOne(Integer id, Company company);
    CommonResponseDTO<?> deleteOne(Integer id);
}
