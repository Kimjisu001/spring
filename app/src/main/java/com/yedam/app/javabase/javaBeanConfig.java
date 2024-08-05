package com.yedam.app.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//특별한 관계가 없는 애들은 이렇게 사용하면 됨
@Configuration //내부에 빈과 관련된 설정을 들고 있음.
public class javaBeanConfig {
	
	@Bean //메소드를 실행한 결과를 빈으로 등록하겠다.
     public Chef chef() {
    	 return new Chef();
		
	}
	@Bean
	public Restaurant restaurant (Chef chef) {
		return new Restaurant(chef);
	}
}
