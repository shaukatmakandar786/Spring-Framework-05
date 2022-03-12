package com.shaukat.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaukat.beans.HelloBean;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		HelloBean h1=(HelloBean)context.getBean("helloBean");
		System.out.println(h1.sayHello());
		context.registerShutdownHook();
	}

}
