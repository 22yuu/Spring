package kr.co.ch04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // @Component랑 똑같지만 의미를 갖는 컴포넌트임
public class MainController {

	@RequestMapping(value = {"/","/index"}) // 시작페이지 설정
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/hello") // 요청 주소 선언
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		return "greeting";
	}
	
}
