package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class CartVo {

	private int seq;
	private String uid;
	private int code;
	private String name;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int delivery;
	private int total;
	private String rate;
	
	// μΆκ°νλ
	private int cate1;
	private int cate2;
	private String thumb1;
	
}
