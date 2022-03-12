package com.shaukat.beans;

public class HelloBean {

	private String name;
	private String message;

	public String getName() {
		return name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void init()
	{
		System.out.println("init()-method");
		name="Asif";
		message="Good Morning";
	}
	public void destroy()
	{
		System.out.println("destroy()-method");
		name="";
		message="";
	}
	
	public String sayHello()
	{
		return "Hello "+name+ ","+message;
	}
}
