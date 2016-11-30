package com.journaldev.hibernate.model;

import java.util.Date;

public class Employee {


	private Integer id;
	private String name;
	private String role;
	private Date insertTime;
	private Department department;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Department getDepartment() {return department;}
	public void setDepartment(Department department) {	this.department = department;	}

	@Override
	public String toString() {
		return "Id:"+id+" Name:"+name+" Role:"+role+" Date: "+insertTime;
	}


}
