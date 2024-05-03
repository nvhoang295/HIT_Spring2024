package com.viethoang.week07.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record CommonResponseDTO<T>(
        Boolean success,

        String message,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        T item
) {
}
