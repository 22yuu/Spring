package kr.co.sboard.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.service.UserService;
import kr.co.sboard.vo.MemberVo;
import kr.co.sboard.vo.TermsVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/", "/index"})
	public String index(HttpSession sess) {
		MemberVo member = (MemberVo)sess.getAttribute("sessMember");
		if(member == null) {
			// 로그인을 안했으면
			return "forward:/user/login";
		}else {
			// 로그인을 했으면
			return "forward:/list";
		}
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	@PostMapping("/user/login")
	public String login(HttpSession sess, MemberVo vo) {
		
		MemberVo member = userService.selectUser(vo);
		
		if(member != null) {
			sess.setAttribute("sessMember", member);
			return "redirect:/list";
		} else {
			return "redirect:/user/login?sucess=101";
		}
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession sess) {
		
		sess.invalidate();
		
		return "redirect:/user/login";
	}
	
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(HttpServletRequest req, MemberVo vo) {

		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		userService.insertUser(vo);
		return "redirect:/user/login";
	}
	
	@GetMapping("/user/terms")
	public String terms(Model model) {
		TermsVo terms = userService.selectTerms();
		model.addAttribute("terms", terms);
		return "/user/terms";
	}
}
