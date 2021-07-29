package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ShopDao;
import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Service
public class ShopService {
	
	@Autowired
	private ShopDao dao;
	
	public ProductVo selectTitles(int cate1, int cate2) {
		return dao.selectTitles(cate1, cate2);
	}
	
	
	public void insertProduct(ProductVo vo) {
		
	};
	
	public ProductVo selectProduct(int code) {
		return dao.selectProduct(code);
	};
	
	public List<ProductVo> selectProducts(int cate1, int cate2, String sort) {
		return dao.selectProducts(cate1, cate2, sort);
	};
	
	public void updateProduct(int code) {
		
	};
	
	public void deleteProduct(int code) {
		
	};
	
	
	public int selectCountCart(int code, String uid) {
		return dao.selectCountCart(code, uid);
	}
	
	public void insertCart(CartVo vo) {
		dao.insertCart(vo);
	}
	
	
	public List<CartVo> selectCart(String uid) {
		return dao.selectCart(uid);
	}
	
	public void insertOrder(OrderVo vo) {
		dao.insertOrder(vo);
	}
	
	public void insertOrderDetail(int orderId, int code) {
		dao.insertOrderDetail(orderId, code);
	}
	
	public void deleteCart(String uid, int code) {
		dao.deleteCart(uid, code);
	}
	
	public List<OrderVo> selectOrders(int orderId) {
		return dao.selectOrders(orderId);
	}
	
	public int updateOrder(OrderVo vo) {
		return dao.updateOrder(vo);
	}
}
