package com.shaukat.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaukat.beans.Student;
import com.shaukat.beans.Address;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Student std=(Student)context.getBean("std");
		System.out.println(std);
	}
}
