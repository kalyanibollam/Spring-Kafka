package com.kafka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee1")
public class Employee1 {
	@Id
	private long employeeId;
	@Column(name = "empName")
	private String empName;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "jobLevel")
	private String jobLevel;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "rating")
	private String rating;
	
	public Employee1(long employeeId, String empName, String designation, String jobLevel, double salary,
			String rating) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.designation = designation;
		this.jobLevel = jobLevel;
		this.salary = salary;
		this.rating = rating;
	}
	public Employee1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
}
