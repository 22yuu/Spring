package kr.co.ch03.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 날짜 : 2021/07/13
 * 이름 : 이진유
 * 내용 : 스프링 AOP 실습하기
 * 
 * 스프링 AOP(Aspect Oriented Programming)
 * 
 * 조인포인트(JointPoint)
 * 
 * 포인트컷(PointCut)
 * 
 * 어드바이스(Advice)
 * 
 * 에스펙트(Aspect)
 * 
 * 위빙(Weaving)
 * 
 */

public class AOPMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		ArticleDao dao = (ArticleDao)ctx.getBean("articleDao");
		dao.insertArticle();
		dao.selectArticle();
		dao.updateArticle();
		dao.deleteArticle();
		
	}
}
