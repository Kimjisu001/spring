package com.yedam.app.test.web;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;
@CrossOrigin(origins = "*") //해당 컨트롤러에 모든 요청이 허용됨
@Controller
public class ParamController {
   //QueryString (질의문자열) : key=value&key=value...
	@RequestMapping(path = "reqparm", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam(@RequestParam Integer employeeId, String lastName, @RequestParam(name="message",defaultValue = "No message", required = true) String msg) {
		String result = "";
		result += "Path : /reqparm \n";
		result += "\t employee_id :" + employeeId;
		result += "\t last_name :" + lastName;
		result += "\t message : " + msg;
		return result;
	}
   //Content-type
	//Method: 상관없음

	//QueryString => @RequestParam : 기본타입, 단일값	
	//QueryString => 커맨드 객체 (어노테이션 X, 객체)
	@RequestMapping(path = "comobj",
					method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
     public String commandObject(EmpVO empVO) {
		String result = "";
		result += "Path : /comobj \n";
		result += "\t employee_id :" + empVO.getEmployeeId();
		result += "\t last_name :" + empVO.getLastName();
		return result;
	}
		
	//@PathVariable은 필수값임.값이 누락되면 404뜸.
	//다른 애들과 혼합해서 주로 씀
	@RequestMapping(path = "path/{id}")//
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result = "";
		result += "Path : /path/{id} \n";
		result += "t id:" + id;
		return result;
	}
	
	//ResponseBody json으로 작성 됨(Body에 작성해야 함.)
	// @RequestBody : JSON 포맷, 배열 or 객체
	// Method : POST, PUT
	// Content-type : application/json
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result = "path : /resbody \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();		
		return result;
	}
	
	@PostMapping("resbodyList")
	@ResponseBody
	public String requestBodyList
				(@RequestBody List<EmpVO> list) {
		String result = "path : /resbodyList \n";
		for(EmpVO empVO : list) {
			result += "\t employee_id : " + empVO.getEmployeeId();
			result += "\t last_name : " + empVO.getLastName();
			result += "\n";
		}
		return result;
	}
}
