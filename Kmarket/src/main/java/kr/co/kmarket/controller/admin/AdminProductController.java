package kr.co.kmarket.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.admin.AdminProductService;
import kr.co.kmarket.vo.Cate1Vo;
import kr.co.kmarket.vo.Cate2Vo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	
	@GetMapping("/admin/product/list")
	public String list() {
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
	
	// ResponseBody 어노테이션을 사용하면 Json데이터로 리턴해줌
	@ResponseBody  
	@GetMapping("/admin/product/getCate1")
	public List<Cate1Vo> getCate1() {
		List<Cate1Vo> cate1s = service.selectCate1();
		return cate1s;
	}
	
	@ResponseBody  
	@GetMapping("/admin/product/getCate2")
	public List<Cate2Vo> getCate2(int cate1) {
		List<Cate2Vo> cate2s = service.selectCate2(cate1);
		return cate2s;
	}
	
	
}