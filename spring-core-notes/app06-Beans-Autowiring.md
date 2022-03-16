# Beans Autowiring/Beans Collaboration

  In general, in spring applications, if we want to inject dependent values in setter
  method dependency injection or in constructor dependency injection we have to use
  <property> or <constructor-arg> tags under <bean> tag. If we want to inject simple
  values like primitive values, string values then we have to use "value" attribute and if
  we want to inject Secondary data type elements like Objects then we have to use "ref"
  attribute or we have to use <ref> tag in beans configuration file.  

  In spring applicatins , if we want to inject dependent bean objects to another bean
  object automatically with out providing <property> tags and <constructor-arg> tags
  then we have to use "Autowiring" feature.  

  "Autowiring" feature of spring framework will make the IOC Container to inject
  dependent objects to the bean objects automatically on the basis of the properties
  names or on the basis of properties types with out checking <property> tags and
  <constructor-arg> tags.  

  There are four ways to manage autowiring in Spring applications.  

    1. XML Based Autowiring
    2. Annotation Based Autowiring
    3. Auto-Discovery[Stereo Types]
    4. Java Based Autowiring
  
# 1.XML Based Autowiring
    
  In this approach, If we want to provide autowiring in spring applications then we have to use "autowire" attribute in <bean> tag.  
 
  EX:
  <bean id="--" class="--" autowire="value">   
   
  Here value may be either of the following "autowiring modes".   
    
  1.no  
  2.byName  
  3.byType  
  4.constructor  
    
### 1.no
    
It is representing "no" autowiring for the beans injection, we must provide explicit
configuration for the beans injection. 
    
    
### 2.byName
    
It will provide autowiring on the basis of the properties names. In this autowiring
mode, IOC Conainer will search for dependent bean objects by matching bean  
properties names with the identity values of the beans configuration in spring
configuration file.  
    
### 3.byType
It will provide autowiring on the basis of the properties data types. In this autowiring
mode, IOC Container will identify the dependent bean objects by matching properties
data types with the bean data types[ class attribute values] in bean configuration.  
    
Note: In Beans configuration file, only one bean definition must be existed with the
same type , if we provide more than one bean configuration with the same type in
beans configuration file then IOC Container will rise an exception.  
    
### 4.constructor
    
It is same as "byType" autowiring mode, but, "byType" autowiring will provide setter
method dependency injection and "constructor" autowiring mode will provide
constructor dependency injection on the basis of the types.  
    
# Address.java
    
  package com.shaukat.beans;

  public class Address {

    private String hno;
    private String city;
    private String state;
    public String getHno() {
      return hno;
    }
    public void setHno(String hno) {
      this.hno = hno;
    }
    public String getCity() {
      return city;
    }
    public void setCity(String city) {
      this.city = city;
    }
    public String getState() {
      return state;
    }
    public void setState(String state) {
      this.state = state;
    }
    @Override
    public String toString() {
      return "Address [hno=" + hno + ", city=" + city + ", state=" + state + "]";
    }


  }
    
# Employee.java
    
  package com.shaukat.beans;

  public class Employee {

    private String eno;
    private String ename;
    private Address eaddr;
    public String getEno() {
      return eno;
    }
    public void setEno(String eno) {
      this.eno = eno;
    }
    public String getEname() {
      return ename;
    }
    public void setEname(String ename) {
      this.ename = ename;
    }
    public Address getEaddr() {
      return eaddr;
    }
    public void setEaddr(Address eaddr) {
      this.eaddr = eaddr;
    }
    @Override
    public String toString() {
      return "Employee [eno=" + eno + ", ename=" + ename + ", eaddr=" + eaddr + "]";
    }


  }
    
# beans.xml

     <beans ---->

    <bean id="eaddr" class="com.shaukat.beans.Address">
      <property name="hno" value="H-111" />
      <property name="city" value="Pune" />
      <property name="state" value="Maharashtra" />
    </bean>

    <bean id="employee" class="com.shaukat.beans.Employee" autowire="byName">

      <property name="eno" value="E-101" />
      <property name="ename" value="shaukat" />


    </bean>

  </beans>
   
# Test.java
    
    package com.shaukat.test;

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    import com.shaukat.beans.Address;
    import com.shaukat.beans.Employee;

    public class Test {

      public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Employee employee=context.getBean("employee",Employee.class);
        System.out.println(employee);
      }
    }
    
    output: Employee [eno=E-101, ename=shaukat, eaddr=Address [hno=H-111, city=Pune, state=Maharashtra]]
    
If we want to provide example for "constructor" autowiring then we have to use the
following components in the above example  
    
# Address.java
    
      same as above
    
# Employee.java
    
    package com.shaukat.beans;

    public class Employee {

      private String eno;
      private String ename;
      private Address eaddr;

      public Employee(String eno, String ename, Address eaddr) {
        super();
        this.eno = eno;
        this.ename = ename;
        this.eaddr = eaddr;
      }

      @Override
      public String toString() {
        return "Employee [eno=" + eno + ", ename=" + ename + ", eaddr=" + eaddr + "]";
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

      <bean id="eaddr" class="com.shaukat.beans.Address">
        <property name="hno" value="H-111" />
        <property name="city" value="Pune" />
        <property name="state" value="Maharashtra" />
      </bean>

      <bean id="employee" class="com.shaukat.beans.Employee" autowire="constructor">

        <constructor-arg name="eno" value="E-101" />
        <constructor-arg name="ename" value="shaukat" />


      </bean>

    </beans>
    
# Test.java
    
      same as above
    
Note: If we want to block any bean object in autowiring then we have to use "autowire-
candidate" attribute with "false" value in <bean> tag in beans configuration file.

    <beans>
    <bean id="scourse" class="com.durgasoft.beans.Course"
    autowire-candidate="false">
    ----
    </bean>
    <bean id="student" class="com.durgasoft.beans.Student" autowire="byType">
    ----
    </bean>
    </beans>    
