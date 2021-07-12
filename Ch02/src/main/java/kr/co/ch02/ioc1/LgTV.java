package kr.co.ch02.ioc1;



public class LgTV implements Tv{
	
	@Override
	public void power() {
		System.out.println("LgTV - power...");
		
	}
	
	@Override
	public void chUp() {
		System.out.println("LgTV - chUp...");
	}
	
	@Override
	public void chDown() {
		System.out.println("LgTV - chDown...");		
	}
}
