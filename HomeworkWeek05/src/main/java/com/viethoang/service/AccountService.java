package com.viethoang.service;

import com.viethoang.dto.CommonResponseDTO;
import com.viethoang.dto.CreateAccountRequestDTO;
import com.viethoang.dto.GetItemsResponseDTO;
import com.viethoang.entity.Account;

public interface AccountService {
	CommonResponseDTO<?> getAccountByUsername(String username);
	GetItemsResponseDTO<Account> getAllAccounts();
	CommonResponseDTO<?> createAccount(CreateAccountRequestDTO request);
	CommonResponseDTO<?> deleteAccountByUsername(String username);
	
}
