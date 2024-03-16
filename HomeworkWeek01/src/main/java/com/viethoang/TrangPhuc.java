package com.viethoang;

import org.springframework.stereotype.Component;

@Component("TrangPhuc")
public class TrangPhuc implements Outfit {

	@Override
	public void getOutfitName() {
		System.out.println("Trang phuc");
	}

}
