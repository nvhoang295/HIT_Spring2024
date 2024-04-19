package com.viethoang.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MismatchedPasswordException extends RuntimeException {
	private String message;
}
