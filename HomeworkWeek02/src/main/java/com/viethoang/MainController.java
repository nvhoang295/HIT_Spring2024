package com.viethoang;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	List<User> users = new ArrayList<>(List.of(
				User.builder().name("Hoang").gender("male").build(), 
				User.builder().name("Duong").gender("male").build(), 
				User.builder().name("Kien").gender("male").build()));
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("message", "");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			Model model) {
		if (username.equals("viethoang") && password.equals("1234")) {
			// nó return về thằng page chứ không return về get mapping method viết ở dưới nên phải add attribute vào
			model.addAttribute("users", users);
			return "home";
		}
		model.addAttribute("message", "Đăng nhập thất bại!");
		return "redirect:login";
	}
	
	@GetMapping("/home")
	public String listUsers(Model model) {
		model.addAttribute("users", users);
		return "home";
	}
	
	@GetMapping("/json")
	@ResponseBody
	public List<User> getUsersJsonFormat() {
		return users;
	}
}
