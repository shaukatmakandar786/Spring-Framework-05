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
    
    
