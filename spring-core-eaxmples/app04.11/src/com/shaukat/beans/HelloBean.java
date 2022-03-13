package com.shaukat.beans;

import org.springframework.beans.factory.InitializingBean;

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
	
//	public void init()
//	{
//		System.out.println("init()-method");
//		name="Asif";
//		message="Good Morning";
//	}
//	public void destroy()
//	{
//		System.out.println("destroy()-method");
//		name="";
//		message="";
//	}
	
	public String sayHello()
	{
		return "Hello "+name+ ","+message;
	}
	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("initializing through afterPropertiesSet()");
//		name="shaukat";
//		message="Good morning";
//	}
//	
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("destroy method");
//	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("post construct");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("pre destroy");
	}
	
}
