package com.viethoang;

import org.springframework.stereotype.Component;

@Component("Vest")
public class Vest implements Outfit {

	@Override
	public void getOutfitName() {
		System.out.println("Wearing vest");
	}

}
