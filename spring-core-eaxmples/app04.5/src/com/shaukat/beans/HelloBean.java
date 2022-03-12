package com.shaukat.beans;

public class HelloBean {

	static {
		System.out.println("Hello bean class loading");
	}
	public HelloBean()
	{
		System.out.println("HelloBean class Instantiating");
	}
	
	public String sayHello()
	{
		return "Hello Guys...!";
	}
}
