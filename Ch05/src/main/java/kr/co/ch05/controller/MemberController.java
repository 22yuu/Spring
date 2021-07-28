package kr.co.ch05.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch05.service.MemberService;
import kr.co.ch05.vo.MemberVo;

@Controller
public class MemberController {
	
	@Inject
	private MemberService service;
	
	@GetMapping("/member/list")
	public String list(Model model) {
		
		List<MemberVo> members = service.selectUsers();
		
		model.addAttribute("members", members);
		
		return "/member/list";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVo vo) {
		
		service.insertUser(vo);
		
		return "/member/register";
	}
	
	@GetMapping("/member/modify")
	public String modfiy(String uid, Model model) {
		
		MemberVo member = service.selectUser(uid);
		
		model.addAttribute("member", member);
		
		return "/member/modify";
	}
	
	@PostMapping("/member/modify")
	public String modify(MemberVo vo) {
		
		service.updateUser(vo);
		
		return "redirect:/member/list";
	}
	
	
	@GetMapping("/member/delete")
	public String delete(String uid) {
		
		service.deleteUser(uid);
		return "redirect:/member/list";
	}
}
