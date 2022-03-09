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
