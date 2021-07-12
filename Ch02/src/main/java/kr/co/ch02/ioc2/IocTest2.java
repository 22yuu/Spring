package kr.co.ch02.ioc2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 날짜 : 2021/07/12
 * 이름 : 이진유
 * 내용 : 스프링 Ioc 어노테이션 기반 DI 실습하기
 */
public class IocTest2 {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		Tv ltv = (Tv)ctx.getBean("lgTV");
		Tv stv = (Tv)ctx.getBean("samsungTV");
		
		ltv.power();
		ltv.chUp();
		ltv.chDown();
		ltv.soundUp();
		ltv.soundDown();
		
		stv.power();
		stv.chUp();
		stv.chDown();
		stv.chUp();
		stv.chDown();
		
	}
}
