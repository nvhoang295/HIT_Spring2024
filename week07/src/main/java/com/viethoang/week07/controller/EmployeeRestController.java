package com.viethoang.week07.controller;

import com.viethoang.week07.constant.URLConstant;
import com.viethoang.week07.entity.Employee;
import com.viethoang.week07.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @PostMapping(URLConstant.Employee.ADD_ONE)
    public ResponseEntity<?> addEmployee(
            @PathVariable("company-id") Integer companyId,
            @RequestBody Employee employee
    ) {
        return ResponseEntity.ok(employeeService.addOne(companyId, employee));
    }
}
