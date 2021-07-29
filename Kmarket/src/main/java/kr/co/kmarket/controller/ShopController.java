package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.service.ShopService;
import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/shop/cart")
	public String cart(HttpSession sess, Model model) {
		
		MemberVo member = (MemberVo)sess.getAttribute("sessMember");
		
		
		if(member == null ) {
			return "redirect:/member/login?sucess=103";
		} else {
			String uid = member.getUid();
			List<CartVo> carts = service.selectCart(uid);
			model.addAttribute("carts", carts);
			return "/shop/cart";
		}
	}
	
	@ResponseBody
	@PostMapping("/shop/cart")
	public String cart(CartVo vo, HttpSession sess) {
		
		MemberVo member = (MemberVo)sess.getAttribute("sessMember");
		
		int result = 0;
		
		if(member != null ) { // 로그인을 했으면

			String uid = member.getUid();
			int code = vo.getCode();
			
			vo.setUid(uid);
			
			int count = service.selectCountCart(code, uid);
			
			if(count < 1) {
				service.insertCart(vo);
				result = 1;
			} else {
				// 이미 상품이 장바구니에 있을 경우
				result = 3;
			}
		} else {
			//로그인을 하지 않음
			result = 2;
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/shop/list")
	public String list(Model model, int cate1, int cate2, String sort) {
		
		ProductVo titles = service.selectTitles(cate1, cate2);
		List<ProductVo> products = service.selectProducts(cate1, cate2, sort);
		
		model.addAttribute("titles", titles);
		model.addAttribute("cate1", cate1);
		model.addAttribute("cate2", cate2);
		model.addAttribute("products", products);
		
		return "/shop/list";
	}
	
	@GetMapping("/shop/order")
	public String order(int orderId, Model model, HttpSession sess) {
		
		MemberVo member = (MemberVo)sess.getAttribute("sessMember");
		
		if(member == null) {
			return "redirect:/member/login?success=105";
		} else {
			List<OrderVo> orders = service.selectOrders(orderId);
			
			System.out.println(orders);
			model.addAttribute("orders", orders);
			model.addAttribute("infoData", orders.get(0));
			model.addAttribute("memberVo", member);
			
			return "/shop/order";
		}
	}
	
	@ResponseBody
	@PostMapping("/shop/order")
	public String order(OrderVo vo) {
		
		service.insertOrder(vo);
		int orderId = vo.getOrderId();
		
		for(int code : vo.getCodes()) {
			service.insertOrderDetail(orderId, code);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("orderId", orderId);
		
		//System.out.println("orderId : " + orderId);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/shop/order-complete")
	public String orderComplete() {
		return "/shop/order-complete";
	}
	
	@ResponseBody
	@PostMapping("/shop/order-complete")
	public String orderComplete(OrderVo vo) {
		
		System.out.println(vo.getApplyPoint());
		System.out.println(vo.getZip());
		System.out.println(vo.getAddr1());
		System.out.println(vo.getAddr2());
		int result = service.updateOrder(vo);
		
		// 멤버 업데이트
		
		
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	
	@ResponseBody
	@PostMapping("/shop/del")
	public String delCart(String uid, int[] codes) {
		
		int size = codes.length;
		
		for(int i = 0; i < size; i++) {
			service.deleteCart(uid, codes[i]);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("uid", 1);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/shop/search")
	public String search() {
		return "/shop/search";
	}
	
	@GetMapping("/shop/view")
	public String view(Model model, int code) {
		
		ProductVo product = service.selectProduct(code);
		
		model.addAttribute("product", product);
		
		return "/shop/view";
	}
}
