package com.yedam.app.aop.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.relational.core.sql.Join;
import org.springframework.stereotype.Component;

import com.yedam.app.emp.service.EmpVO;

@Aspect //AOP 설정 담당(하나의 컴포넌트가 될거임.동작하는 부분은 일반 빈이랑 동일...하다는데?)
@Component
public class CommonAspect {
	//포인트컷 : 조인 포인트 중에서 Advice(횡단관심)이 적용될 메소드 필터
    @Pointcut("within(com.yedam.app.emp.service.impl.*)")//within 검색 조건, 지정한 경로 아래에 모든 비즈니스 메소드를 총칭함...?  
	public void empPointCut() {}//적용된 포인트 컷을 불러오는 역할을 함 / 적용 코드 / 적용시점
    
    // Weaving: 포인크 컷+타이밍+Advice(횡단관심)
	@Before("empPointCut()") //적용할 시점 : 
	                         //before : 포인트컷 메소드 실행되기 전에 사전작업을 해야할때
	                         //after : 포인트컷 메소드 실행 후 예외발생여부 관계없이 무조건 실행
	                         //after-returning : 포인트컷 메소드가 정상적으로 실행 후 리턴 시점
	                         //after-throwing : 포인트컷 메소드가 실행되다가 예외 발생 시점
	                         //around :  메소드 실행 전과 실행 후에 모두 동작(실행방법이 before,after 와는 다름)
	public void beforeAdvice(JoinPoint joinPoint) { //수행할 어드바이스 /joinPoint를 통해 지금 실행하는 메소드 
		String sinagerStr = joinPoint.getSignature().toString();
		Object[] args = joinPoint.getArgs();
		System.out.println("#####실행:" + sinagerStr);			
		for(Object arg: args) {
			System.out.println("매개변수");
			if(arg instanceof Integer) {
			 System.err.println((Integer)arg);
		}else if(arg instanceof EmpVO) {
			System.err.println((EmpVO)arg);
		}
		}
	}//beforeAdvice end
	
	@Around("empPointCut()")//비즈니스 메소드를 딜레이 시킬수 있음.
	//매개변수로 조인 포인트를 넘겨받아서 실제 비즈니스 코드를 실행함. 시간 체크에 많이 사용함(시작지점 끝난 시점 실행 타임 체크 많이 함).
	public Object executeTime(ProceedingJoinPoint joinPoint) throws Throwable {
	 String signaterStr = joinPoint.getSignature().toString();
	 //공통기능
	 System.out.println("===핵심 기능 전 실행:" + System.currentTimeMillis());
	 try {
		 //비즈니스 메소드를 실행
		 Object obj = joinPoint.proceed();
		 return obj;
	 }finally { //에러가 나든 정상적이든 무조건 실행
		 //공통기능
		 System.out.println("===핵심 기능 후 실행:"+System.currentTimeMillis());
		 System.out.println("===끝:"+signaterStr);
	 }
	}
}
