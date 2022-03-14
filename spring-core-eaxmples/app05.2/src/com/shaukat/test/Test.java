package com.shaukat.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaukat.beans.Account;
import com.shaukat.beans.Employee;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Employee emp=(Employee)context.getBean("emp");
		System.out.println(emp);
	}
}
