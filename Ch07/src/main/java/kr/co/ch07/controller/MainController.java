package kr.co.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch07.vo.UserVO;

@Controller
public class MainController {

	@GetMapping(value= {"/", "/index"})
	public String index(Model model) {
		
		String title = "스프링부트 타임리프 연습하기";
		String hello = "Hello Thymeleaf";
		
		UserVO user = new UserVO();
		user.setUid("a101");
		user.setName("홍길동");
		user.setHp("010-1234-1010");
		user.setAge(21);
		
		List<UserVO> users = new ArrayList<>();
		users.add(new UserVO("a101","김유신","010-1234-1111",21));
		users.add(new UserVO("a102","김춘추","010-1234-2222",22));
		users.add(new UserVO("a103","장보고","010-1234-3333",32));
		users.add(new UserVO("a104","강감찬","010-1234-4444",33));
		users.add(new UserVO("a105","이순신","010-1234-5555",25));
		
		model.addAttribute("title", title);
		model.addAttribute("hello", hello);
		model.addAttribute("user", user);
		model.addAttribute("users", users);
		//model.addAttribute("user", null);
		
		return "/index";
	}
}