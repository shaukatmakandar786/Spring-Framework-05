package com.shaukat.beans;

public class Employee {

	private int eno;
	private String name;
	private double sal;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	public void empDetails()
	{
		System.out.println("Employee details");
		System.out.println("------------------");
		System.out.println("Employee No:"+eno);
		System.out.println("Employee Name:"+name);
		System.out.println("Employee Salary:"+sal);
	}
}
