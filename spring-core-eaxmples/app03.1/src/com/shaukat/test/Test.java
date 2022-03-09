package com.shaukat.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.shaukat.beans.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Resource resource=new ClassPathResource("com/shaukat/resourses/applicationContext.xml");
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		Employee employee=(Employee)beanFactory.getBean("emp");
		employee.empDetails();
	}

}
