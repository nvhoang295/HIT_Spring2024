package com.viethoang.week07.service.impl;

import com.viethoang.week07.dto.CommonResponseDTO;
import com.viethoang.week07.dto.PaginationRequestDTO;
import com.viethoang.week07.dto.PaginationResponseDTO;
import com.viethoang.week07.entity.Company;
import com.viethoang.week07.repository.CompanyRepository;
import com.viethoang.week07.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public CommonResponseDTO<Company> getOne(Integer id) {
        return CommonResponseDTO.<Company>builder()
                                .success(true)
                                .message("Tim thay")
                                .item(companyRepository.findById(id)
                                                       .orElseThrow(() -> new RuntimeException("Khong tim thay")))
                                .build();
    }

    @Override
    public PaginationResponseDTO<Company> getList(PaginationRequestDTO request) {
        Sort sort = request.direction().equals("asc") ? Sort.by(request.fields()).ascending()
                                                      : Sort.by(request.fields()).descending();

        Pageable pageable = PageRequest.of(request.index(), request.size(), sort);

        Page<Company> page = request.q() == null ? companyRepository.findAll(pageable)
                                                 : companyRepository.search(pageable, request.q());

        return PaginationResponseDTO.<Company>builder()
                                    .keyword(request.q())
                                    .pageIndex(request.index())
                                    .pageSize(page.getSize())
                                    .totalItems(page.getTotalElements())
                                    .totalPages(page.getTotalPages())
                                    .items(page.getContent())
                                    .build();
    }

    @Override
    public CommonResponseDTO<Company> addOne(Company company) {
        return CommonResponseDTO.<Company>builder()
                                .success(true)
                                .message("Them thanh cong!")
                                .item(companyRepository.save(company))
                                .build();
    }

    @Override
    public CommonResponseDTO<Company> updateOne(Integer id, Company company) {
        Optional<Company> found = companyRepository.findById(id);

        if (found.isEmpty()) throw new RuntimeException("Khong tim thay!");

        found.get().setName(company.getName());

        return CommonResponseDTO.<Company>builder()
                                .success(true)
                                .message("Sua thanh cong")
                                .item(companyRepository.save(found.get()))
                                .build();
    }

    @Override
    public CommonResponseDTO<?> deleteOne(Integer id) {
        Optional<Company> found = companyRepository.findById(id);

        if (found.isEmpty()) throw new RuntimeException("Khong tim thay!");

        companyRepository.delete(found.get());

        return CommonResponseDTO.builder()
                .success(true).build();
    }
}
