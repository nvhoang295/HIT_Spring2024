package com.viethoang.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viethoang.dto.CreateAccountRequestDTO;
import com.viethoang.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AccountRestController {
	private final AccountService service;
	
	@GetMapping("/accounts/{username}")
	public ResponseEntity<?> getAccountByUsername(
			@PathVariable(name = "username") String username
	) {
		return ResponseEntity.ok(service.getAccountByUsername(username));
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<?> getAllAccounts() {
		return ResponseEntity.ok(service.getAllAccounts());
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<?> createAccount(
			@RequestBody CreateAccountRequestDTO request
	) {
		return ResponseEntity.created(null).body(service.createAccount(request));
	}
	
	@DeleteMapping("/accounts/{username}")
	public ResponseEntity<?> deleteAccountByUsername(
			@PathVariable(name = "username") String username
	) {
		return ResponseEntity.ok(service.deleteAccountByUsername(username));
	}
}
