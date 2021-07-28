package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Repository
public interface ShopDao {

	public void insertProduct(ProductVo vo);
	public ProductVo selectProduct(int code);
	public ProductVo selectTitles(int cate1, int cate2);
	public List<ProductVo> selectProducts(int cate1, int cate2, String sort);
	public void updateProduct(int code);
	public void deleteProduct(int code);
	
	
	// 장바구니
	public int selectCountCart(int code, String uid);
	public void insertCart(CartVo vo);
	public List<CartVo> selectCart(String uid);
	public void insertOrder(OrderVo vo);
	public void insertOrderDetail(int orderId, int code);
	public void deleteCart(String uid, int code);
}
