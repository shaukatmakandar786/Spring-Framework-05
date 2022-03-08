1. Pass as parameters to Business method in bean class.  
2. Providing setXXX() and getXXX() methods in bean clas and by executing setXXX() method.  
3. By declaring data in spring configuration file as property in bean configuration  

Spring:  
Example on Bean and its configuration in spring configuration file.  

# HelloBean.java  

    package com.shaukat.beans;  

    public class HelloBean {  

	   private String name;  
	
	   public String getName() {  
		  return name;  
	    }  
	    public void setName(String name) {  
		    this.name = name;  
	    }  

	    public String sayHello(/* String name */)  
	    {  
		    return"Hello "+name;  
	    }  
    }  
    
# applicationContext.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="helloBean" class="com.shaukat.beans.HelloBean">
     	<property name="name" value="Shaukat Makandar"></property>  
    </bean>


    </beans>

# Test.java:

    package com.shaukat.test;

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    import com.shaukat.beans.HelloBean;

    public class Test {

	    public static void main(String[] args) {
		
		  ApplicationContext context=new ClassPathXmlApplicationContext("com/shaukat/resourses  /applicationContext.xml");
		  HelloBean hBean=(HelloBean)context.getBean("helloBean");
    //		System.out.println(hBean.sayHello("Shaukat"));
    //		hBean.setName("Shaukat");
    //		System.out.println(hBean.sayHello());
	   	System.out.println(hBean.sayHello());
		
	    }

    }
