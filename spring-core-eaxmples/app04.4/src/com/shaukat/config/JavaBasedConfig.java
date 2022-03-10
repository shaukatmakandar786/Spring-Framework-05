package com.shaukat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shaukat.beans.HelloBean;
import com.shaukat.beans.WelcomeBean;

@Configuration
public class JavaBasedConfig {

	@Bean
	public WelcomeBean welcomeBean()
	{
		return new WelcomeBean();
	}
	
	@Bean
	public HelloBean helloBean()
	{
		HelloBean h1=new HelloBean();
		h1.setName("shaukat");
		return h1;
	}
}
