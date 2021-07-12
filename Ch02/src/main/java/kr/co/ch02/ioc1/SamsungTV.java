package kr.co.ch02.ioc1;

public class SamsungTV implements Tv {
	
	@Override
	public void power() {
		System.out.println("SamsungTV - power...");
		
	}
	
	@Override
	public void chUp() {
		System.out.println("SamsungTV - chUp...");
	}
	
	@Override
	public void chDown() {
		System.out.println("SamsungTV - chDown...");
	}
}
