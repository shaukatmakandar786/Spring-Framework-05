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
    
