# Beans-in-Spring-Framework:

1. Beans Definitions
2. Beans Configuration
3. Beans Scopes
4. Beans Lifecyle
5. Beans Inheritence
6. Nested Beans
7. BeanPostProcessor

# 1. Beans Definitions

a. Bean is a reusable component, it is a normal java class,it will have:  

    i. properties  
    ii. setXXX() and getXXX() methods for each and every properties.  
    iii. Business Methods  
    iv. Event-Notification model  
    v. Data Validation  
    ------------------  
    ------------------  
    
b. Rules and Regulation to use Bean in Spring:  

    i. In Spring Application,Bean components must be POJO classes, They must not implement or exted predefined liabrary except.io.Serializable.  
    
    ii. In Bean classes we have to declared properties and we provide a seprate set of setXXX() and getXXX() methods.  
    
    iii. In Spring Application,Bean classes must be public,non abstarct, non final.  
    
    iv. In Spring Framework, inside beans, all properties must be declared as a private and all methods must be declared as public.  
    
    v.  In Bean classes if we want to declare any constructor then it is possible to provide public and 0-args constructor.  
    
    vi. If we want to provide our own comparision between bean class then it is suggestable to override equals(--).  
    
    vii. If we want to generate hasgcode values to the Bean objects in our own view then we have to override hasCode() method.  
    
# 2. Beans Configuration

--> We must provide details of the bean classes to the containers inorder to Instantiate.  

1. XML Basd Configuration  
2. Anntation Based Configuration  
3. Java Based coniguration  

## 1. XML Basd Configuration:  

if we provide beans details to the containers through an XML file then it is called as XML configuration.  

    <beans---------->    
        <bean id="----" name="-----" scope="----">  
            --------  
         </beans>  
     </beans>  
     
     <bean> tag can be used to provide single bean configuration details.  
     id: it will provide an identity value for the bean object.  
     name:it will provide an identity and alias names to the bean object.  
     scope:it can be used to specify a particular spring scope inorder to keep Bean objects.  
     
## Q) What is the diffrence between 'id' and 'name' attributes?

1. 'id' attribute will take single value that is identity for the bean object inorder to retriave.  
2. 'name' attribute will take one or more no of values with , or ; or space seprator.If we provide more than one values then first value is treated as identity for the bean object and the remaining values are treated as alisa names to the bean identity.  

### Note:  
In Bean configuration,we can provide bean class configuration with 'name' attribute and without 'id' attribute.  

In bean configuration, we can provide both 'id' attribute and 'name' attribute, at that time 'id' attribute treated as bean identity and 'name' attribute values are treated as bean alias names.  

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

	    public String sayHello()
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

    <bean name="helloBean1 helloBean2,helloBean3;helloBean4" class="com.shaukat.beans.HelloBean">  
        <property name="name" value="Shaukat Makandar"></property>  
  	</bean>  
  	
  	<bean id="helloBean" class="com.shaukat.beans.HelloBean">  
     	<property name="name" value="Shaukat Makandar"></property>  
  	</bean>  
  	
	<bean id="hello" name="hello1 hello2" class="com.shaukat.beans.HelloBean">  
     	<property name="name" value="Shaukat Makandar"></property>  
  	</bean>  

    </beans>  
    
# Test.java  

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
    
3. Where 'class' attributes is able to take fully qualified name of the respective bean class.
4. Where 'acope' attribute will take a particular spring scope.

# Scopes in Spring Framework:

Spring Framework has provided 7 types of scopes to make available Bean object and to generate same or different bean for our Bean request.

1. Singleton Scope
2. Prototype Scope
3. Request Scope
4. Session Scope
5. globaleSession Scope
6. application Scope
7. webSocket Scope

# 1. Singleton Scope

1. It is default scope in spring application.
2. It will create a seperate Bean object for each and every bean definition in Spring Configuration.

![Singleton Example](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.2)

# 2. Prototype Scope

1. It is not default scope in Spring Application.
2. It allows to create a seperate Bean object for each and every request for Bean, that is , for each and every getbean() method call.

![Prototype Example](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.3)

# 3. Java Based configuration  

Upto Spring 2.4 version,it mandatory to provide Spring configuration file but, from Sprinmg 3.x version onwards,Spring configuration file is optional, we can use Spring configuration class as an alternative for Spring configuration file.

1. Create Bean classes as per the requirement.
2. Create Spring configuration class with the requirement methods by using the following annotations.  
			
		i. @Configuration
		ii. @Bean
		
3. In main method use the following container class.

		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(configClass.class)  
		
4. Get Bean object.

		public Object getBean(Class c)/public Object getBean(String methodName)
		
5. Access Business Methods.		
	
![Java Based Configuration Example](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.4)	

# 4. Beans Lifecyle

In Spring Framework, bean life cycle conatins the following stages.

1. Bean Class Loading
2. Bean Instantiation
3. Bean Initialization
4. Bean Destruction

## 1. Bean Class Loading

Loading Bean class byte code to the memory.

Class c=class.forName(com.shaukat.beans.HelloBean)

## 2. Bean Instantiation

Creating Object for the loaded Bean class.

1. By using Constructor directly.
![Creating Bean object using constructor directly](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.5)

2. By Using static Factory method.
![Creating Bean object using static Factory method](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.6)

3. By using instance Factory method.
![Creating Bean object using Instance Factory method](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.7)

## 3. Bean Initialization and Bean Destruction

1. By using 'property' tag in XML file
![Bean Initialization example by using property tag](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app03.1
)

2. By using Custom init-method and destroy-method method.
![Custome Bean Initialization Example](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.8
)
3. By using InitializingBean and Disposable callback interface
![Custome Bean Initialization Example](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.9
)

4. By using @PostContruct and @PreDestroy annotations.
![Custome Bean Initialization Example](https://github.com/shaukatmakandar786/Spring-Framework-05/tree/main/spring-core-eaxmples/app04.11
)

### Note:
In general in Spring Framework application,we are able to use either of the above three approaches to perform bean initialization and destruction,we are not using all three approaches at a time.If we use all three above approaches in single bean then IOC container will execute the above three approaches provided initialization methods and destruction in the following order.

#### Initialization Order:

1. @PostConstruct
2. afterProperiesSet() provided by InitializingBean interface
3. init-method in bean tag

#### Destruction Order:

1. @PreDestroy
2. destroy() provided by DisposableBean interface
3. destroy-method in bean tag
