package com.fisa.model.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@ToString

@Entity(name = "fisadept18")
public class DeptCopy {  //dept_copy
	
	@Id
	private int deptno;  //deptNo -> dept_no 알아서 반환
	private String dname;
	private String loc;
}
