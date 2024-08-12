package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;




@RestController
public class DeptRestController {
     private DeptService deptService;
     
     @Autowired
     DeptRestController(DeptService deptService){
    	 this.deptService = deptService;
     }
     //전체조회
     @GetMapping("depts")
     public List<DeptVO> deptList(){
    	 return deptService.deptList();
     }
     
     //단건조회
     @GetMapping("depts/{did}")
     public DeptVO deptInsert(@PathVariable(name="did") Integer departmentId) {
    	 DeptVO deptVO = new DeptVO();
    	 deptVO.setDepartmentId(departmentId);
    	 return deptService.deptInfo(deptVO);
     }
}
