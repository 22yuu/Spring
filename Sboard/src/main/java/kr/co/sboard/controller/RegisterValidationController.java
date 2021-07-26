package kr.co.sboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sboard.service.UserService;

@Controller
public class RegisterValidationController {
	
	@Autowired
	private UserService service;
	
	@ResponseBody
	@GetMapping("/register/checkUid")
	public int checkUid(String uid) {
		int result = service.selectMemberCount(uid);
		//System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@GetMapping("/register/checkNick")
	public int checkNick(String nick) {
		int result = service.selectMemberCount(nick);
		//System.out.println(result);
		return result;
	}
	
	
	@ResponseBody
	@GetMapping("/register/checkEmail")
	public int checkEmail(String email) {
		int result = service.selectMemberCount(email);
		//System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@GetMapping("/register/checkHp")
	public int checkHp(String hp) {
		int result = service.selectMemberCount(hp);
		//System.out.println(result);
		return result;
	}
	
	
	
}
