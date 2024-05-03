package com.viethoang.service;

import com.viethoang.dto.CommonResponseDTO;
import com.viethoang.dto.CreateAccountRequestDTO;
import com.viethoang.dto.GetItemsResponseDTO;
import com.viethoang.entity.Account;

public interface AccountService {
	CommonResponseDTO<?> getOne(Integer id);
	GetItemsResponseDTO<Account> getList();
	GetItemsResponseDTO<Account> searchList(String keyword);
	CommonResponseDTO<?> addOne(CreateAccountRequestDTO request);
	CommonResponseDTO<?> deleteOne(Integer id);
	CommonResponseDTO<?> updateOne(Integer id, String password);
	
}
