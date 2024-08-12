package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;


@Controller
public class DeptController {
     private DeptService deptService;
     
     @Autowired
     public DeptController(DeptService deptService) {
 		this.deptService =deptService;
 	} 
     
     //전체 조회
     @GetMapping("deptList")
     public String deptList(Model model) {
     	List<DeptVO> list = deptService.deptList();
     	model.addAttribute("depts", list);
         return "dept/list";
     }
     
     //등록-페이지확인(컨트롤러가 기본적으로 2개)GET
     @GetMapping("deptInsert")
     public String deptInsertForm() {
     	return "dept/insert";
     }
     
     //등록-등록후 페이지 재확인
     //경로:http://localhost:8099/yedam/deptInfo?departmentId=100
     @PostMapping("deptInsert")
     public String deptInsertProcess(DeptVO deptVO) {
     	int did = deptService.deptInsert(deptVO);
     	String url = null;
     	if(did > -1) {
     		url= "redirect:deptInfo?departmentId="+did;
     	}else {
     			url="redirect:deptList";
     		}
     		return url;
     }//deptInsertProcess end
     

     //수정-페이지확인(컨트롤러가 기본적으로 2개)GET
     @GetMapping("deptUpdate")
     public String deptUpdateFrom(DeptVO deptVO, Model model) {
        DeptVO findVO = deptService.deptInfo(deptVO);
        model.addAttribute("dept",findVO);
        return "dept/update";
     }//empUpdateFrom end
     
     //수정 : 수정 후 페이지 확인 /아작스의 제이슨 타입
     @PostMapping("deptUpdate")
     @ResponseBody
     public Map<String, Object> deptupdateAJAXJSON(@RequestBody DeptVO deptVO){ 
     	return deptService.deptUpdate(deptVO);
        }
     
     //삭제
     @GetMapping("deptDelete")
     public String deptDelete(Integer departmentId) {
    	 deptService.deptDelete(departmentId);
     	return "redirect:deptList";
     }
}
