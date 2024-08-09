package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

// @모든 메서드에 @ResponseBody를 사용하겠습니다. 선언
@RestController
public class EmpRestController {
	private EmpService empService;
	
	@Autowired
	EmpRestController(EmpService empService){
		this.empService = empService;
	}
	//메소드를 기반으로 등록인지 수정인지 삭제인지 구분함. 메소드: 동작 url:접근하고자 하는 자원
	//전체조회:GET => emps
	@GetMapping("emps")
	public List<EmpVO> empList(){
		return empService.empList();
	}
	
	//단건조회:GET => emps/100 (경로구성: 조회하고자 하는 대상, 패스베리어블(경로에 붙을 변수값을 가져오는 것),제이슨 기준으로 넘김 (?뒤로는 데이터,/는 경로))
	@GetMapping("emps/{eid}")
	public EmpVO empInfo(@PathVariable(name="eid") Integer employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.empInfo(empVO);
	}
	
	//등록:POST => emps 바디를 요구하기 때문에 POST방식 사용
	//@RequestBody 제이슨(서버에서 클라이언트로 데이터를 보낼 때 사용하는 양식)으로 바디를 받는다.
	@PostMapping("emps")
	public int empInsert(@RequestBody EmpVO empVO) {
		return empService.empInsert(empVO);
	}
	
	//수정:PUT => emps/100 (경로구성: 경로에 검색하고자 하는 대상을 붙혀서(emps/100) or 바디안에 넣어서 보내는 경우도 있음)
	@PutMapping("emps/{employeeId}")
	public Map<String,Object> 
	    empUpdate(
		//경로를 통해서 수정할 대상
		@PathVariable Integer employeeId, 
		//수정할 정보는 JSON포멧으로
		@RequestBody EmpVO empVO){
		    empVO.setEmployeeId(employeeId);
			return empService.empUpdate(empVO);
		
	}
	
	//삭제:DELETE => emps/100 (경로구성: GET이랑 같아서 바디가 없음 그래서 경로에 붙혀야 함)
    @DeleteMapping("emps/{employeeId}")
    public Map<String,Object> empDelete(@PathVariable Integer employeeId){
    	    return empService.empDelete(employeeId);
    	}
}
