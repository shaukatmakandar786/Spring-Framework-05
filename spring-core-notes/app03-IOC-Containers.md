# IOC[Inversion of Control] Containers:  

The main intension of IOC container is to create Bean objects and to supplay Bean object to the Spring Application.  

There are two types of IOC containers:  

    1.  BeanFactory  
    2.  ApplicationContext  
    
# BeanFactory:  
    
a. It is basic fundamental container to create Bean object in Spring Applicatons.  

b. It is providing the functionalities like Creating bean objects and supplying bean objects to the Spring Application,it is not providing  
the advanced features like I18N, Event Notification Model,.... in Spring Applications.

c.BeanFactory is depricated from Spring3.x version.  

d.BeanFactory is represented by Spring Framework in the form of interface "org.springframework.beans.factory.BeanFactory".  

e.Spring Framework has provided an implementation class to BeanFactory interface in the form of "org.springframework.beans.factory.xml.XmlBeanFactory".  

f.There are three steps to use BeanFactory.  

    i. Create Resource Object.  
    ii. create BeanFactory Object.  
    iii. Get Bean Object from BeanFactory and Access Business Methods.  

### Create Resource Object:  

a. To represent beans configuration details which we provide in Spring configuration file then we have to use Resource object.  

b. To represent resource objects, Spring Framwork has provide a predefine interface in the form of "org.springframework.core.io.Resource".  

c. Spring Framework has provide predefined implementation classes for Resource interface.  

    i. org.springframework.core.io.ByteArrayResource    
    ii. org.springframework.core.io.FileSystemResource    
    iii. org.springframework.core.io.ClassPathResource   
    iv. org.springframework.core.io.InputStreamResource  
    v. org.springframework.core.io.UrlResource  
    vi. org.springframework.web.context.support.ServletContextResource  
    vii. org.springframework.web.portlet.context.PortletContextResource  

    Resource resource=new ClassPathResource("spring-config.xml");  

### Create BeanFactory Object:

    BeanFactory factory=new XmlBeanFactory(resource);  

### Get Bean Object from BeanFactory and Access Business Methods:

    public void getBean(String id)  
  
    HelloBean hello=(HelloBean)factory.getBean("helloBean");  
    
![How BeanFactory works internally](https://github.com/shaukatmakandar786/Spring-notes-images/blob/main/BeanFactory01.png)    

# BeanFactory Example:

## Employee.java

        package com.shaukat.beans;  

        public class Employee {  

	        private int eno;  
	        private String name;  
	        private double sal;  
	
	        public int getEno() {  
		        return eno;  
	        }  
	        public void setEno(int eno) {  
		        this.eno = eno;  
	        }  
	        public String getName() {  
		        return name;  
	        }  
	        public void setName(String name) {  
		        this.name = name;  
	        }  
	        public double getSal() {  
		        return sal;  
	        }  
	        public void setSal(double sal) {  
		        this.sal = sal;  
	        }  
	
	        public void empDetails()  
	        {  
		        System.out.println("Employee details");  
		        System.out.println("------------------");  
		        System.out.println("Employee No:"+eno);  
		        System.out.println("Employee Name:"+name);  
		        System.out.println("Employee Salary:"+sal);  
	        }  
        }  
        
## applicationContext.xml

            <?xml version="1.0" encoding="UTF-8"?>  
            <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans
             https://www.springframework.org/schema/beans/spring-beans.xsd">

                <bean id="emp" class="com.shaukat.beans.Employee">  
                    <property name="eno" value="101"/>  
                    <property name="name" value="shaukat"/>  
                <property name="sal" value="60000"/>  
       
              </bean>  


            </beans>  

## Test.java  

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

    
 # ApplicationContext:  
 
 a. ApplicationContext is an IOC container in Spring Framework,it will creates bean object and it will supplay Bean object to Spring Applications.  
 
 b. ApplicationContext is child to BeanFactory, it able to perform all functionalities what BeanFactory is performing and it will provied the advanced features like I18N,Even Notification Model,...  
 
 c. In Spring Framework ApplicationContext is represented in the form of a predefined interface "org.springframework.context.ApplicationContext", it is child interface to "BeanFactory" interface.  
 
 d. Spring Framework has provided the following implementation classes for ApplicationContext interface.
 
    i. ClassPathXmlApplicationContext
    ii. FileSystemXmlApplicationContext  
    iii. WebXmlApplicationContext  
    
    ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");  
    
![BeanFactoryHirarchy](https://github.com/shaukatmakandar786/Spring-notes-images/blob/main/BeanFactoryHirarchy02.png)  

### if we want to use ApplicationContext container in Spring Application:

1. Prepare Bean class as per the requirements.  
2. Prepare Spring configuration file and provide configurations.  
3. Prepare test Application, where we must use ApplicationContext container to manage beans.  


# ApplicationContext Example

## Student.java

	package com.shaukat.beans;  

	public class Student {  

		private int rno;  
		private String name;  
	
		public int getRno() {  
			return rno;  
		}  
		public void setRno(int rno) {  
			this.rno = rno;  
		}   
		public String getName() {  
			return name;  
		}  
		public void setName(String name) {  
			this.name = name;  
		}  
	
		public void getStudentDetails()  
		{  
			System.out.println("Students Details...");  
			System.out.println("---------------------");  
			System.out.println("Roll No:="+rno);  
			System.out.println("Name:="+name);  
		}  
	}  

## ApplicationContext.xml

	<?xml version="1.0" encoding="UTF-8"?>  
	<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">  

    	<bean id="student" class="com.shaukat.beans.Student">  
        	<property name="rno" value="101"></property>  
     		<property name="name" value="Shaukat Makandar"></property>  
  	</bean>  


	</beans>  
	
## Test.java

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


![applicationContext how internally works](https://github.com/shaukatmakandar786/Spring-notes-images/blob/main/ApplicationContext03.png)
