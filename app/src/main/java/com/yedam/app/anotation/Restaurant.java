package com.yedam.app.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 

@Component //빈으로 등록하겠다.
public class Restaurant {
   private  Chef chef;
   //생성자 인젝션 셰프를 데리고 온다음 레스토랑을 만듬
   @Autowired //생성자 인젝션. 직접적으로 쓰는 대상 바로 위에 보통 메서드 위에 존재함.
   public Restaurant(Chef chef) {
	this.chef = chef;
}
   //세터 인젝션 (기본생성자가 있어야함.) 레스토랑을 만들고 셰프를 데려옴 
   public Restaurant() {}
   public void setChef(Chef chef) {
	   this.chef =chef;
	   System.out.println();
   }
   
   public void run() {
	chef.cooking();
}
}
