package com.yedam.app.dept.service;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

//getter, setter, toString, equals, hashCode 메서드가 자동으로 생성
@Data
//리퀘스트 아그스 컨스트럭터: 필수적인 값들을 초기화 할 수 있도록 자동으로 생성자를 만들어주는 역할
@RequiredArgsConstructor
@EqualsAndHashCode
public class DeptVO {
	private Integer departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
