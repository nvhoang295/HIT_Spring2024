package com.viethoang.week07.controller;

import com.viethoang.week07.constant.URLConstant;
import com.viethoang.week07.dto.PaginationRequestDTO;
import com.viethoang.week07.entity.Company;
import com.viethoang.week07.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CompanyRestController {
    private final CompanyService companyService;

    @GetMapping(URLConstant.Company.GET_ONE)
    public ResponseEntity<?> getOne(
            @PathVariable(name = "company-id") Integer companyId
    ) {
        return ResponseEntity.ok(companyService.getOne(companyId));
    }

    @GetMapping(URLConstant.Company.GET_LIST)
    public ResponseEntity<?> getList(
            PaginationRequestDTO request
    ) {
        return ResponseEntity.ok(companyService.getList(request));
    }

    @PostMapping(URLConstant.Company.ADD_ONE)
    public ResponseEntity<?> addOne(
            @RequestBody Company company
    ) {
        return ResponseEntity.ok(companyService.addOne(company));
    }

    @PutMapping(URLConstant.Company.UPDATE_ONE)
    public ResponseEntity<?> updateOne(
            @PathVariable(name = "company-id") Integer companyId,
            @RequestBody Company company
    ) {
        return ResponseEntity.ok(companyService.updateOne(companyId, company));
    }

    @DeleteMapping(URLConstant.Company.DELETE_ONE)
    public ResponseEntity<?> deleteOne(
            @PathVariable(name = "company-id") Integer companyId
    ) {
        return ResponseEntity.ok(companyService.deleteOne(companyId));
    }
}
