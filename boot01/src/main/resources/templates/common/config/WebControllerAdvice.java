package com.yedam.app.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WebControllerAdvice {
//컨트롤러 어드바이스: 컨트롤러에서 발생하는 예외처리 담당, 모든 컨트롤러가 공용으로 사용하는 변수 등록
	//모델 어트리뷰트 변수 등록
	//ModelAttribute전역변수 선언("contextPath")변수명
	@ModelAttribute("contextPath")
	public String contextPath(final HttpServletRequest request) {
		return request.getContextPath();
	}
}
