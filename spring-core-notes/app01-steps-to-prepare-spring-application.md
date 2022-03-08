# Steps to prepare First Spring Application[Core Module]:

1. Download spring farmework[Jars] from Internet.  
2. Prepare java project in Eclips IDE.  
3. Prepare spring liabrary with required jar files.  
4. Prepare Bean class.  
5. Prepare Spring configuration with bean class.  
6. Prepare Test Application.  

# 1. Download spring farmework[Jars] from Internet.  

https://repo.spring.io/ui/native/release/org/springframework/spring

1. commons-logging-1.2  
2. spring-beans-4.3.4.RELEASE.jar
3. spring-context-4.3.4.RELEASE.jar  
4. spring-context-support-4.3.4.RELEASE.jar  
5. spring-core-4.3.4.RELEASE.jar  

# 2. Prepare java project in Eclips IDE.  

# 3. Prepare spring liabrary with required jar files.  

# 4. Prepare Bean class.  

a. Bean is a reusable component,it is a normal java class having properties and the respective setXXX() and getXXX() methods.  

b. Spring Framework is using POJO[Plain Old Java Object] classes ,it will not extend or implement any predefine liabrary except java.io.Serializable marker interface.  

    UseBean----> JSP  
    ActionForm/FormBean---> Struts  package com.shaukat.beans;

public class HelloBean {

	public String sayHello()
	{
		return "Hello Guys...!";
	}
}
    BackingBean---> JSF  
    POJO---> Hibernate  
    POJO---> Spring  
    
c. In Spring Framework, POJO class must be Java bean class,It must be declared as a public ,non abstract and non final.  
    
    i. The main intention of declaring Bean as a public is to make available to spring Framework indore to create objects.  
    ii. In Spring Framework Applications, Spring Framework must create object for the Bean class,it must be non abstract.  
    iii. In Spring Framework Application, if we want to extends one bean class to another class as per the requirements and   
    as per improviding code reusability we must declared bean class non final.  
    
d. In bean class we must declared properties as per the requirement and we must provide a seprate set of setXXX() methos and getXXX() method.  

e. In bean class we must declared all propertires as private properties ,we must declare  
all method as public methods inorder to improve "Encapsulation".  

f. In beans class if we want to provide constructor then we can to provide constructor,butitmust be public and 0-arg  
constructor,because while instantiating Bean class,Spring Framework will search and execute 0-arg constructor and public constructor.

g. If we want to provide our own comparision between Bean object then we have to override equals() method.  

h. If we want to generate hashcode values of the Bean object in our own view then we have to override hasCode() method.  

# 5. Prepare Spring configuration with bean class.  

a. It is an XML file, it will include all beans configuration details like name of the Bean class, identity of the Bean class.properties of and their values of the Bean class.  
b. The main intension of Bean configuration is Spring configuration file is to create Bean object by spring Framework..  
c. Spring Framework is able to allow any name to the configuration file, but the suggestible name is "applicationContext.xml".  
  
  
    <beans  ---XSD>  
        -----  
        <bean id="---" class="---"/>  
         -----  
    </beans>  

id:it will take a variable name as an identity to generate bean Object.  
class:It will take fully qualified name of the respective Bean class.  

    <beans  ---XSD>  
         -----  
        <bean id="helloBean" class="com.shaukat.HelloBean"/>  
         -----  
    </beans>  

# 6. Prepare Test Application.  

a. The main intention of Test Application is to activate Containers from Spring Framework and allows to create Bean object by getting beans from spring configuration file and to use Bean objects in our application as per the requirement.  


b. There are two types of containers in Spring Framework.  

     i. BeanFactory  
     ii. ApplicationContext
    
ApplicationContext is an interface provided by Spring Framework and one its implementation  
is "ClassPathXmlApplicationContext",  

c. To create ApplicationContext container we have to use the following code.  
    ApplicationContext cnxt=new ClassPathXmlApplicationContext("/com/shaukat/resources/applicationContext.xml");  
    
    i. ApplicationContext container will take name and location of the spring conf file.  
    ii. ApplicationContext container will load spring configuration file to memory.  
    iii. ApplicationContext container will parse spring configuration file.  
    iv. ApplicationContext container will read beans configuration details from sping configuration file.  
    v. ApplicationContext container will create bean class objects and maintain bean class object.  
    
d. Get bean object from ApplicationContext container on the basis if id.  

    public Object getBean(String id);  

    HelloBean hb=(HelloBean)cnxt.getBean("helloBean");  
    
## First Example on Spring Framework:  

### HelloBean.java  

    package com.shaukat.beans;  

    public class HelloBean {  

	    public String sayHello()  
	    {  
		    return "Hello Guys...!";  
	    }  
    }  

### beans.xml  

    <?xml version="1.0" encoding="UTF-8"?>  
        <beans xmlns="http://www.springframework.org/schema/beans"  
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
         xsi:schemaLocation="http://www.springframework.org/schema/beans  
             https://www.springframework.org/schema/beans/spring-beans.xsd">  

         <bean id="helloBean" class="com.shaukat.beans.HelloBean">  
              <!-- collaborators and configuration for this bean go here -->  
         </bean>  
   
        </beans>  
        
### Test.java  

       package com.shaukat.test;

       import org.springframework.context.ApplicationContext;
       import org.springframework.context.support.ClassPathXmlApplicationContext;

       import com.shaukat.beans.HelloBean;  

       public class Test {  

	        public static void main(String[] args) {  
		        // TODO Auto-generated method stub  
		        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");  
		        HelloBean hBean=(HelloBean)context.getBean("helloBean");  
		        System.out.println(hBean.sayHello());  
	        }  

        }  
