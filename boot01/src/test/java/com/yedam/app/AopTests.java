package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
public class AopTests {
 @Autowired
 AaaService aaaService;
 
 @Test
 void transcationalTest() {
	 aaaService.insert();
 }
 
 @Autowired
 PasswordEncoder passwordEncoder;


@Test
void pwdEnconderTest() {
	String password = "1234";
	
	//DB에 저장된 비밀번호 => 암호화 작업
	String enPwd = passwordEncoder.encode(password);//passwordEncoder.encode 비밀번호를 암호화 함
	System.out.println(enPwd);
	
	boolean result = passwordEncoder.matches(password, enPwd); //password, enPwd를 비교하는데 2번째에 들어오는걸 암호화된 대상으로 봄.
	System.out.println(result);
}


}