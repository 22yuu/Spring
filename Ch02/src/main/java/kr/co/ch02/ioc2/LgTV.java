package kr.co.ch02.ioc2;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements Tv{
	
	@Inject
	private Speaker spk;
	
//	public LgTV(Speaker spk) {
//		this.spk = spk;
//	} @Inject이나 @Autowired 어노테이션을 추가해주면서 생성자 생성 x
	
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
	@Override
	public void soundUp() {
		spk.soundUp();
	}
	
	@Override
	public void soundDown() {
		spk.soundDown();
	}
}
