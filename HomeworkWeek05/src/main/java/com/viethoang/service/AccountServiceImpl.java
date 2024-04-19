package com.viethoang.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.viethoang.dto.CommonResponseDTO;
import com.viethoang.dto.CreateAccountRequestDTO;
import com.viethoang.dto.GetItemsResponseDTO;
import com.viethoang.entity.Account;
import com.viethoang.exception.DuplicateUsernameException;
import com.viethoang.exception.MismatchedPasswordException;
import com.viethoang.exception.NotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class AccountServiceImpl implements AccountService {
	
	private List<Account> accounts = new ArrayList<>();
	
	@PostConstruct
	public void initListAccount() {
		for (int i = 1; i <= 10; i++) {
			accounts.add(Account.builder().username("user" + i).password("123").build());
		}
	}
	
	@Override
	public CommonResponseDTO<?> getAccountByUsername(String username) {
		Optional<Account> found = accounts.parallelStream()
				.filter(item -> item.getUsername().equals(username))
				.findFirst();
		
		if (found.isEmpty()) throw new NotFoundException("Khong tim thay username nay!");
		
		return CommonResponseDTO.<Account>builder()
				.result(true)
				.message("Tim thay account!")
				.item(found.get())
				.build();
	}

	@Override
	public GetItemsResponseDTO<Account> getAllAccounts() {
		return GetItemsResponseDTO.<Account>builder()
				.items(accounts)
				.build();
	}

	@Override
	public CommonResponseDTO<?> createAccount(CreateAccountRequestDTO request) {
		Optional<Account> found = accounts.parallelStream()
				.filter(item -> item.getUsername().equals(request.username()))
				.findFirst();
		
		if (found.isPresent()) 
			throw new DuplicateUsernameException("Username nay da duoc su dung, mat khau cua username nay la: " + found.get().getPassword());
		
		if (!request.password().equals(request.confirmPassword()))
			throw new MismatchedPasswordException("Mat khau xac nhan khong khop!");
		
		accounts.add(Account.builder().username(request.username()).password(request.password()).build());
		
		return CommonResponseDTO.builder().result(true).message("Them thanh cong!").build();
	}

	@Override
	public CommonResponseDTO<?> deleteAccountByUsername(String username) {
		Optional<Account> found = accounts.parallelStream()
				.filter(item -> item.getUsername().equals(username))
				.findFirst();
		
		if (found.isEmpty()) throw new NotFoundException("Khong tim thay username nay!");
		
		accounts.remove(found.get());
		
		return CommonResponseDTO.builder()
				.result(true).message("Xoa thanh cong!")
				.build();
	}

}
