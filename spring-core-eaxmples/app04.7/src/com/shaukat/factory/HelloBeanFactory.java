package com.shaukat.factory;

import com.shaukat.beans.HelloBean;

public class HelloBeanFactory {

	public HelloBean getHelloBeanInstance()
	{
		System.out.println("getHelloBeanInstance executed");
		return new HelloBean();
	}
}
