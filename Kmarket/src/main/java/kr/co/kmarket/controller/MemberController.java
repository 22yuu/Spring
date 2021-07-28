package kr.co.kmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		
		sess.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) {
		
		MemberVo membervo = service.selectMember(uid, pass);

		if(membervo != null) {
			// 로그인 성공
			sess.setAttribute("sessMember", membervo);
			return "redirect:/";
			
		} else {
			// 로그인 실패
			return "redirect:/member/login?success=0";
		}
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(HttpServletRequest req, MemberVo vo) {
		
		String ip = req.getRemoteAddr();
		vo.setIp(ip);
		vo.setType(0); // 0 : 일반 회원, 1 : 판매 회원, 2 : 관리자
		service.insertMember(vo);
		
		return "redirect:/";
	}
	
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	
	@GetMapping("/member/signup")
	public String signup() {
		return "/member/signup";
	}
	
}
