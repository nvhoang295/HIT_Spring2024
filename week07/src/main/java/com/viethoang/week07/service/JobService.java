package com.viethoang.week07.service;

import com.viethoang.week07.dto.CommonResponseDTO;
import com.viethoang.week07.dto.PaginationRequestDTO;
import com.viethoang.week07.dto.PaginationResponseDTO;
import com.viethoang.week07.entity.Job;

public interface JobService {
    CommonResponseDTO<Job> getOne(Integer id);
    PaginationResponseDTO<Job> getList(PaginationRequestDTO request);
    CommonResponseDTO<Job> addOne(Job job);
    CommonResponseDTO<Job> updateOne(Integer id, Job job);
    CommonResponseDTO<Job> deleteOne(Integer id);
    PaginationResponseDTO<Job> getListByEmployee(Integer employeeId, PaginationRequestDTO request);
    PaginationResponseDTO<Job> getListByCompany(Integer companyId, PaginationRequestDTO request);
}
