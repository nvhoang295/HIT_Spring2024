package com.viethoang.dto;

import java.util.List;

import lombok.Builder;

@Builder
public record GetItemsResponseDTO<T>(
		List<T> items
) {

}
