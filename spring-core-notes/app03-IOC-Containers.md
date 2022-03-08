# IOC[Inversion of Control] Containers:  

The main intension of IOC container is to create Bean objects and to supplay Bean object to the Spring Application.  

There are two types of IOC containers:  

    1.  BeanFactory  
    2.  ApplicationContext  
    1.  BeanFactory   
    
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

## Create Resource Object:  

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

## Create BeanFactory Object:

    BeanFactory factory=new XmlBeanFactory(resource);  

## Get Bean Object from BeanFactory and Access Business Methods:

    public void getBean(String id)  
  
    HelloBean hello=(HelloBean)factory.getBean("helloBean");  
