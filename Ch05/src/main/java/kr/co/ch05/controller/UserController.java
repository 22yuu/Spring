package kr.co.ch05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/list")
	public String list() {
		return "/user/list";
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@GetMapping("/user/modfiy")
	public String modfiy() {
		return "/user/modfiy";
	}
	
}
