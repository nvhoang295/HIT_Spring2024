package com.viethoang.week07.dto;

import org.springframework.web.bind.annotation.RequestParam;

public record PaginationRequestDTO(
        @RequestParam(name = "q", required = false) String q,

        @RequestParam(name = "index", required = false) Integer index,

        @RequestParam(name = "direction", required = false) String direction,

        @RequestParam(name = "size", required = false) Short size,

        @RequestParam(name = "fields", required = false) String... fields
) {
}
