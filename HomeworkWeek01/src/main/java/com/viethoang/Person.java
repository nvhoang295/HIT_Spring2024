package com.viethoang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class Person {
	@Autowired
	@Qualifier("TrangPhuc")
	private Outfit outfit;
	
	@Autowired
	@Qualifier("undercut")
	private HairStyle hairStyle;
	
	public void getPersonInfor() {
		outfit.getOutfitName();
		hairStyle.getHairStyleName();
	}
}
