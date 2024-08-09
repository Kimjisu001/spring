package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;


@Controller //클래스는 컨트롤러 붙어야함.
            //route 등록과 같은 개념임: 사용자 요청부분(endpoint)과 그에 대한 처리
            //:URL + METHOD => Service => View 
public class EmpController {
	//해당 컨트롤러에서 제공하는 서비스
    private EmpService empService;
    
    @Autowired
    public EmpController(EmpService empService) {
		this.empService =empService;
	}
    //GET: 조회, 빈페이지(보완이 안됨.)
    //POST: 데이터 조작(등록,수정,삭제 그나마 내용안에 담아서 보내기 때문에 보안을 신경씀.)
    
    //전체 조회(컨트롤러가 하나면 됨.): GET메소드 사용
    @GetMapping("empList")
    //리스트는 사용자에게 전달해야할게 있음. 그 전달할걸 담는 대상이 모델(Model = Request + Response)
    public String empList(Model model) {
    	//컨트롤러는 기본적으로 이 세가지 반복
    	//1) 해당 기능 수행 => Service
    	List<EmpVO> list = empService.empList();
    	//2) 클라이언트에 전달할 데이터 담기
    	model.addAttribute("emps", list);
        return "emp/list";//3) 데이터를 출력할 페이지 결정
    	//classpath:/templates/      emp/list    .html
    	//prefix                     return      subfix
    }

    
    //단건 조회(컨트롤러가 하나면 됨. ) GET => QueryString(커맨드 객체,리퀘스트 파람)
  //경로:http://localhost:8099/yedam/empInfo
    @GetMapping("empInfo")
    public String empInfo(EmpVO empVO, Model model) {
    	//1) 해당 기능 수행 => Service	
    	EmpVO findVO = empService.empInfo(empVO);
    	//2) 클라이언트에 전달할 데이터 담기
    	model.addAttribute("emp",findVO);    	
    	return "emp/info";//3) 데이터를 출력할 페이지 결정//네트워크 통신이 하나만 잡힘. forward방식
    	//return "redirect:empList";//통신이 두개가 잡힘 post못씀
    	//classpath:/templates/      emp/info    .html
    	//prefix                     return      subfix
    }//empInfo end
    //등록-페이지확인(컨트롤러가 기본적으로 2개)GET
    @GetMapping("empInsert")
    public String empInsertForm() {
    	return "emp/insert";
    }
    //등록-처리(컨트롤러가 기본적으로 2개):POST 데이터를 받아야함.커맨드 객체 쓸거냐?웅 form 태그 쓸거냐? form태그를 통한 submit 아작스 권장
    //경로:http://localhost:8099/yedam/empInfo?employeeId=100
    @PostMapping("empInsert")
    public String empInsertProcess(EmpVO empVO) {
    	int eid = empService.empInsert(empVO);
    	String url = null;
    	if(eid > -1) {
    		//등록 성공!
    		url= "redirect:empInfo?employeeId="+eid;
    	}else {
    		//등록 시르패!
    			url="redirect:empList";
    		}
    		return url;
    }//empInsertProcess end
    
    //수정-페이지(컨트롤러가 기본적으로 2개, 원래 가지고 있는 데이터가 이거입니다.알려줌, GET <=> 단건조회)
    @GetMapping("empUpdate")
    public String empUpdateFrom(EmpVO empVO, Model model) {
       EmpVO findVO = empService.empInfo(empVO);
       //컨트롤러가 넘겨주는 값이 뭔지가 가장 중요함. model.addAttribute 페이지를 전달하기 위해 데이터를 담음
       model.addAttribute("emp",findVO);
       return "emp/update";
    }//empUpdateFrom end
    
    //수정-처리:AJAX => QueryString(컨트롤러가 기본적으로 2개, 원래 가지고 있는 데이터가 이거입니다.) 리다이렉트 안함... 수정이 연속으로 일어나는경우가 많음 아작스 권장
    //empUpdate
    @PostMapping("empUpdate")
    //이 컨트롤러는 예외적으로 데이터를 처리해주세용이 리스폰스바디임.
    @ResponseBody
    public Map<String, Object> empupdateAJAXQueryString( EmpVO empVO){ //커맨드 객체로 만들어주면된다는데 음?????
    	return empService.empUpdate(empVO);//리턴하는 데이터를 클라이언트에게 바로 붙혀준당....그래서 리스판스바디가 붙음.
       }
//    //수정-처리:AJAX => JSON
//    @PostMapping("empUpdate")
//    //이 컨트롤러는 예외적으로 데이터를 처리해주세용이 리스폰스바디임.
//    @ResponseBody //AJAX
//    public Map<String, Object> empupdateAJAXJSON(@RequestBody EmpVO empVO){ //커맨드 객체로 만들어주면된다는데 
//    	return empService.empUpdate(empVO);//리턴하는 데이터를 클라이언트에게 바로 붙혀준당....그래서 리스판스바디가 붙음.
//    }    
    //삭제-처리GET(단위값을 넘기는 형태 왜냐? 넘기는 데이터가 많이 없어서 얼마나 값을 넘기느냐에 따라 GET, POST 사용) 아작스 사용마라(아작스 사용하면 새로고침 안되서 페이지가 사용자에게 보임.......)
    @GetMapping("empDelete")
    public String empDelete(Integer employeeId) {
    	empService.empDelete(employeeId);
    	return "redirect:empList";
    }
}
