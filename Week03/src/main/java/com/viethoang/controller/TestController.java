package com.viethoang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.viethoang.Phone;

@Controller
public class TestController {
	private List<Phone> list = new ArrayList<>();
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/about")
	public String addPhone(@RequestParam("name") String name) {
		list.add(new Phone(name));
//		mav.addObject("list", list);
		return "index";
	}
	
	@GetMapping("/about")
	public String listPhones(Model model) {
		model.addAttribute("list", list);
		return "about";
	}
}
