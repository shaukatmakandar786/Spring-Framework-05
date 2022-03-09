package com.shaukat.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaukat.beans.HelloBean;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/shaukat/resourses/applicationContext.xml");
		System.out.println(context.getBean("helloBean1"));
		System.out.println(context.getBean("helloBean1"));
		System.out.println(context.getBean("helloBean1"));
		
		System.out.println(context.getBean("helloBean2"));
		System.out.println(context.getBean("helloBean2"));
		System.out.println(context.getBean("helloBean2"));

	}

}
