package com.viethoang;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
	private String name;
	private String gender;
}
