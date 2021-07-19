package kr.co.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch08.service.UserService;
import kr.co.ch08.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/list")
	public String list(Model model) {
		
		List<UserVo> users = userService.selectUsers();
		
		model.addAttribute("users", users);
		
		return "/user/list";
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVo vo) {
		
		userService.insertUser(vo);
		
		return "/user/register";
	}
	
	@GetMapping("/user/modify")
	public String modify(String uid, Model model) {
		
		UserVo user = userService.selectUser(uid);
		model.addAttribute("user", user);
		return "/user/modify";
	}
	
	@PostMapping("/user/modify")
	public String modify(UserVo vo) {
		
		userService.updateUser(vo);
		
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/delete")
	public String delete(String uid) {
		userService.deleteUser(uid);
		return "redirect:/user/list";
	}
}
