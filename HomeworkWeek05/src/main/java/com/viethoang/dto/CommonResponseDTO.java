package com.viethoang.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;

@Builder
public record CommonResponseDTO<T>(
		Boolean result,
		String message,
		@JsonInclude(value = Include.NON_NULL)
		T item
) {

}
