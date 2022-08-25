package com.mphasis.spring.SpringJdbcAOPDemo.Model;

public class Employee {

	private int Eid;
	private String Name;
	private double Salary;
	private String dept;
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", Name=" + Name + ", Salary=" + Salary + ", dept=" + dept + "]";
	}	
}
