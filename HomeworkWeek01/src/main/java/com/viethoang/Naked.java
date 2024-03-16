package com.viethoang;

import org.springframework.stereotype.Component;

@Component("Naked")
public class Naked implements Outfit {

	@Override
	public void getOutfitName() {
		System.out.println("Wearning nothing!!!! :v");
	}

}
