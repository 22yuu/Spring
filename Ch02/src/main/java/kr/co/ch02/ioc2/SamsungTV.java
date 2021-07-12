package kr.co.ch02.ioc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements Tv {
	
	@Autowired
	private Speaker spk;
	
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
	
	@Override
	public void soundUp() {
		spk.soundUp();
	}
	
	@Override
	public void soundDown() {
		spk.soundDown();
	}
}
