package com.shaukat.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaukat.beans.HelloBean;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/shaukat/resourses/applicationContext.xml");
		HelloBean hBean1=(HelloBean)context.getBean("helloBean1");
		System.out.println(hBean1.sayHello());
		
		HelloBean hBean2=(HelloBean)context.getBean("helloBean2");
		System.out.println(hBean2.sayHello());
		
		HelloBean hBean=(HelloBean)context.getBean("helloBean");
		System.out.println(hBean.sayHello());
		
		HelloBean h1=(HelloBean)context.getBean("hello");
		System.out.println(h1.sayHello());
		
	}

}
