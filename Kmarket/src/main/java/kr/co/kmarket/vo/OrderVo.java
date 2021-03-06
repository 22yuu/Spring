package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class OrderVo {

	private int orderId;
	private String uid;
	private int count;
	private int price;
	private int discount;
	private int delivery;
	private int point;
	private int applyPoint;
	private int total;
	private String orderer;
	private String hp;
	private int zip;
	private String addr1;
	private String addr2;
	private int payment;
	private int complete;
	private String rdate;
	private String completeDate;
	
	//μΆκ° νλ
	private int[] codes;
	
	private int cate1;
	private int cate2;
	private String thumb1;
	private String pName;
	private int pPrice;
	private int pDiscount;
	private int pPoint;
	private int pDelivery;
	private int pTotal;
	
}
