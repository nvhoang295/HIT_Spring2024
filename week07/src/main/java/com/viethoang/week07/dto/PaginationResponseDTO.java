package com.viethoang.week07.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PaginationResponseDTO<T>(
        String keyword,
        Integer pageIndex,
        Integer pageSize,
        Long totalItems,
        Integer totalPages,
        List<T> items
) {
}
