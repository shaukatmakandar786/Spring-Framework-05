# Inversion of Control[IOC]:

The IoC container creates an object of the specified class and also injects all the dependency objects through a constructor dependency injection, setter method dependency injection at run time and disposes it at the appropriate time. This is done so that we don't have to create and manage objects manually. 

## there are two ways to achieve dependency injection:

1. Constructor Dependency injecton
2. Setter Method Dependency Injection

## 1. Constructor Dependency injecton

If we inject dependent values to the bean object through Contructor then this type of Dependency injection is called as "Constructor Dependency Injection".

If we want to use constructor dependency injection in spring application,first we have to declared respective parameterized constructor in the corresponding bean class then we have to declared that constructor arguments in spring configuration file by using the following tags.

    <beans>
      <bean...>
        <construct-arg value="---"/>
        <constructor-arg>value</constructor-arg>
      </bean>
    </beans>  
    
# Course.java

    package com.shaukat.beans;

    import org.springframework.beans.factory.InitializingBean;

    public class Course {

        private String cidString;
        private String cnameString;
        private int ccost;

        public Course(String cidString, String cnameString, int ccost) {
            super();
            this.cidString = cidString;
            this.cnameString = cnameString;
            this.ccost = ccost;
        }
        @Override
        public String toString() {
            return "Course [cidString=" + cidString + ", cnameString=" + cnameString + ", ccost=" + ccost + "]";
        }
    }

# Test.java

    package com.shaukat.test;

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.AbstractApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    import com.shaukat.beans.Course;

    public class Test {

        public static void main(String[] args) {

            ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
            Course course=(Course)context.getBean("course");
            System.out.println(course);
        }

    }

    
# beans.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
            https://www.springframework.org/schema/beans/spring-beans.xsd
            https://www.springframework.org/schema/context
            https://www.springframework.org/schema/context/spring-context.xsd
            ">
        <bean id="course" class="com.shaukat.beans.Course">  
            <constructor-arg value="C-111"/>
            <constructor-arg value="JAVA"/>
            <constructor-arg value="5000"/>	
        </bean>

    </beans>
     
# 2. Setter Method Dependency Injection

If we inject dependency bean values to the Bean through setXXX() methods then it is called as "Setter Method Dependency Injecton".

To Inject primitive values and String value to the bean then have to use "value" attributes in <property> or <constrcut-arg> tags in beans configuration file, but if we want to inject user define data type,that is object reference values then we have to use "ref" attribut in <property> tag or in <construct-arg> tag.

