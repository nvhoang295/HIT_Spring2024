package com.viethoang.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.viethoang.dto.CreateAccountRequestDTO;
import com.viethoang.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AccountRestController {
	private final AccountService service;
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<?> getOne(
			@PathVariable(name = "id") Integer id
	) {
		return ResponseEntity.ok(service.getOne(id));
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<?> getList(
			@RequestParam(name = "keyword", required = false) String keyword
	) {
		return keyword == null ? ResponseEntity.ok(service.getList()) : ResponseEntity.ok(service.searchList(keyword));
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<?> addOne(
			@RequestBody CreateAccountRequestDTO request
	) {
		return ResponseEntity.created(null).body(service.addOne(request));
	}
	
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<?> deleteOne(
			@PathVariable(name = "id") Integer id
	) {
		return ResponseEntity.ok(service.deleteOne(id));
	}

}
