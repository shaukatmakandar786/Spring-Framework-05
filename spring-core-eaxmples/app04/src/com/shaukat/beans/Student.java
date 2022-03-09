package com.shaukat.beans;

public class Student {

	private int rno;
	private String name;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void getStudentDetails()
	{
		System.out.println("Students Details...");
		System.out.println("---------------------");
		System.out.println("Roll No:="+rno);
		System.out.println("Name:="+name);
	}
}
