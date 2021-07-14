package kr.co.ch05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("member/list")
	public String list() {
		return "member/list";
	}
	
	@GetMapping("member/modify")
	public String modify() {
		return "member/modify";
	}
	
	@GetMapping("member/register")
	public String register() {
		return "member/register";
	}
}
