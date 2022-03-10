package com.shaukat.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaukat.beans.HelloBean;
import com.shaukat.beans.WelcomeBean;
import com.shaukat.config.JavaBasedConfig;

public class Test {

	public static void main(String[] args) {
		
		/*
		 * ApplicationContext context=new
		 * AnnotationConfigApplicationContext(JavaBasedConfig.class); String[]
		 * beanNames=context.getBeanDefinitionNames(); for(String beanName:beanNames) {
		 * System.out.println(); }
		 */
		
		ApplicationContext context=new AnnotationConfigApplicationContext(JavaBasedConfig.class);
		WelcomeBean wb1=(WelcomeBean)context.getBean("welcomeBean");
		System.out.println(wb1.getWelcomeMsg());
		
		WelcomeBean wb2=(WelcomeBean)context.getBean(WelcomeBean.class);
		System.out.println(wb2.getWelcomeMsg());
		
		HelloBean h1=(HelloBean)context.getBean(HelloBean.class);
		System.out.println(h1.sayHello());
	}

}
