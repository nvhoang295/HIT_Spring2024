package com.viethoang.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.viethoang.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	private final AccountRepository repository;

	@Override
	public CommonResponseDTO<?> getOne(Integer id) {
		Optional<Account> found = repository.findById(id);
		
		if (found.isEmpty()) throw new NotFoundException("Khong tim thay username nay!");
		
		return CommonResponseDTO.<Account>builder()
				.result(true)
				.message("Tim thay account!")
				.item(found.get())
				.build();
	}

	@Override
	public GetItemsResponseDTO<Account> getList() {
		return GetItemsResponseDTO.<Account>builder()
				.items(repository.findAll())
				.build();
	}

	@Override
	public GetItemsResponseDTO<Account> searchList(String keyword) {
		return GetItemsResponseDTO.<Account>builder()
								  .items(repository.searchAccounts(keyword))
								  .build();
	}

	@Override
	public CommonResponseDTO<?> addOne(CreateAccountRequestDTO request) {
		List<Account> foundList = repository.searchAccounts(request.username());

		if (!foundList.isEmpty())
			throw new DuplicateUsernameException("Username nay da duoc su dung, mat khau cua username nay la: ");
		
		if (!request.password().equals(request.confirmPassword()))
			throw new MismatchedPasswordException("Mat khau xac nhan khong khop!");

		repository.save(Account.builder().password(request.username()).password(request.password()).build());
		
		return CommonResponseDTO.builder().result(true).message("Them thanh cong!").build();
	}

	@Override
	public CommonResponseDTO<?> deleteOne(Integer id) {
		Optional<Account> found = repository.findById(id);
		
		if (found.isEmpty()) throw new NotFoundException("Khong tim thay username nay!");
		
		repository.delete(found.get());
		
		return CommonResponseDTO.builder()
				.result(true).message("Xoa thanh cong!")
				.build();
	}

	@Override
	public CommonResponseDTO<?> updateOne(Integer id, String password) {
		Optional<Account> found = repository.findById(id);
		found.get().setPassword(password);
		return CommonResponseDTO.builder().message("OK").item(repository.save(found.get())).build();
	}

}
