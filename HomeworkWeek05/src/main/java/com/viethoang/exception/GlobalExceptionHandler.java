package com.viethoang.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.viethoang.dto.CommonResponseDTO;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({NotFoundException.class, MismatchedPasswordException.class, DuplicateUsernameException.class})
	public ResponseEntity<?> handleNotFoundException(RuntimeException ex) {
		return ResponseEntity.badRequest()
				.body(CommonResponseDTO
						.builder()
						.result(false)
						.message(ex.getMessage())
						.build()
				);
	}
	
	
	
}
