package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest //jUnit은 얘가 없어도 됨. 하지만 컨테이너를 생성 못함. 테스트 환경에서 IOC컨테이너를 생성해주는 역할
class Boot01ApplicationTests {
    @Autowired //필드 주입(메서드 등을 통하지 않고 테스트 환경에서 강제 주입하여 테스트)
    EmpMapper empMapper;
	//@Test
	void empList() {
		List<EmpVO> list = empMapper.selectEmpAllList();
		assertTrue(!list.isEmpty());//내부값이 비었는지 체크하는 메서드
	}//empList end
	
	//@Test
	void empInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals("King", findVO.getLastName());
	}//empInfo end
	
	//@Test
	void empInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("ddd@google.com");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(1000);
		
		
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println(empVO.getEmployeeId());
		
		assertEquals(1,result);
	}//empInsert end
	
	//@Test
	public void empDelete() {
		int result = empMapper.deleteEmpInfo(716);
		assertEquals(1, result);
	} 
	
	//@Test
	public void empUpdate() {
		// -1) 대상 원래 데이터 조회: 단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(715);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		// -2) 사용자가 수정하는 내용 입력
		findVO.setLastName("Kang");
		// -3) update
		int result = empMapper.updateEmpInfo(findVO.getEmployeeId(), findVO);
		assertEquals(1, result);
	}

}//Boot01ApplicationTests end
