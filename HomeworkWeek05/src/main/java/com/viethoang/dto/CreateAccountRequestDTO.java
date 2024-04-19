package com.viethoang.dto;

import lombok.Builder;

@Builder
public record CreateAccountRequestDTO(
		String username,
		String password,
		String confirmPassword
		
) {

}
