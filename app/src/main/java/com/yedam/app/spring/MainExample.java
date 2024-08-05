package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
     public static void main(String[] args) {
    	 //컨테이너 생성
    	 //저 파일을 집어넣어줘 라는 뜻.. 대강
		ApplicationContext ctx 
		= new GenericXmlApplicationContext("classpath:applicationContext.xml"); //classpath = file:src/main/resources의 단축키
		//원하는 기능 작성
		TV tv = (TV)ctx.getBean("tv");//getBean("아이디 속성")
		tv.turnOn();
		
		TV subTv = (TV)ctx.getBean(TV.class);//클래스 속성 그 자체를 넘김
		subTv.turnOn();
		
		if(tv == subTv) { //같은 인스턴스 인가요? 그렇다면
			System.out.println("같은 빈 입니다.");
		}else {           
			System.out.println("다른 빈 입니다.");
		}//(스프링의 컨테이너 안에는 하나의 빈밖에 없어서 같은 빈입니다)출력
}
}
