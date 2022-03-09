package com.shaukat.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaukat.beans.HelloBean;
import com.shaukat.beans.Student;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/shaukat/resourses/applicationContext.xml");
		Student stud=(Student)context.getBean("student");
		stud.getStudentDetails();
		
	}

}
