package com.viethoang.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.viethoang.User;

@Controller
//@RequestMapping("/test1")
public class UserController {
	
	@RequestMapping(name = "/test", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("string", "Hello world");
		return "test";
	}
	
	@GetMapping("/test2")
	public String test2(Model model) {
		User u = new User("Hoang", 20);
		model.addAttribute("user", u);
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("listUser", List.of(
				new User("Hoang", 20), 
				new User("Huy", 21), 
				new User("Duong", 15)));
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4() {
		return "test4";
	}
	
	@GetMapping("/test5")
	public String test5() {
		return "test5";
	}
	
	@PostMapping("/about")
	public String about(@RequestParam("name") String name, @RequestParam Integer age, Model model) {
		User u = new User(name, age);
		model.addAttribute("user", u);
		return "about";
	}
	
	@PostMapping("/about2")
	public String about2(@ModelAttribute User user, Model model) {
		User u = new User(user.getName(), user.getAge());
		model.addAttribute("user", u);
		
		if (u.getAge() >= 18) {
			return "redirect:test3";
		}
		
		return "about2";
	}
	
	
}
