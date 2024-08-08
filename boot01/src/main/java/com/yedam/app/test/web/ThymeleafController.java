package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ThymeleafController {
	private EmpService empService;
	
	@GetMapping("thymeleaf")
	public String thymeleafTest(Model model){
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo", findVO);//화면 연결과 가장 영향이 큼 empInfo->test.html에 <p>[[${empInfo}]]</p>에서 확인 가능
		return "test";
	}
}
