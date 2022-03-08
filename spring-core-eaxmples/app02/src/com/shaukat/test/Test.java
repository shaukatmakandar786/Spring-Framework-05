package com.shaukat.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaukat.beans.HelloBean;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/shaukat/resourses/applicationContext.xml");
		HelloBean hBean=(HelloBean)context.getBean("helloBean");
//		System.out.println(hBean.sayHello("Shaukat"));
//		hBean.setName("Shaukat");
//		System.out.println(hBean.sayHello());
		System.out.println(hBean.sayHello());
		
	}

}
