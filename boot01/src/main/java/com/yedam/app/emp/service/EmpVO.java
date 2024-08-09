package com.yedam.app.emp.service;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//VO는 
//import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class EmpVO {
    //employee_id -> employeeId
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd") //출력에는 영향을 주지 않음. DateTimeFormat을 들여다보면 심플데이트포멧에 대한 패턴
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
