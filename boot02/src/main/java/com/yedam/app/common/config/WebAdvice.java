package com.yedam.app.common.config;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //모든 컨트롤러에 공통적으로 적용되는 기능 별도 관리
public class WebAdvice {
	//@ExceptionHandler : 특정 예외에 대한 처리 등록
	//@ExceptionHandler(value= SQLException.class)
	//public ResponseEntity<String> handleSqlExcpetion() {
	//	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	//}
	
  @ModelAttribute("contextPath") 
    //@ModelAttribute : 모든 페이지에서 공통적으로 사용
    //실제역할:자신이 선언되어있는 대상을 이 이름으로 담겠다. 페이지
  public String contextPath(HttpServletRequest req) {
	  return req.getContextPath();
  }
}
