package kr.co.kmarket.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.admin.AdminProductDao;
import kr.co.kmarket.vo.Cate1Vo;
import kr.co.kmarket.vo.Cate2Vo;
import kr.co.kmarket.vo.ProductVo;

@Service
public class AdminProductService {
	
	@Autowired
	private AdminProductDao dao;

	public void insertProduct(ProductVo VO) {
		
	};
	
	public ProductVo selectProduct() {
		return null;
	};
	
	public List<ProductVo> selectProducts(){
		return null;
	};
	
	public void updateProduct(ProductVo vo) {
		
	};
	
	public void deleteProduct(ProductVo vo) {
		
	};
	
	// 1차 카테고리 가져오기
	public List<Cate1Vo> selectCate1(){
		return dao.selectCate1();
	};
	
	public List<Cate2Vo> selectCate2(int cate1) {
		return dao.selectCate2(cate1);
	}
}
