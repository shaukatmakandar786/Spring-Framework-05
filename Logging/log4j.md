# log4j:

In Real time applications development, we may get no of problems or bugs or exceptions while  
executing or testing the applications, Ti identify the problems and their locations then we have to  
trace the applications flow of execution.  

If we use System.out.println() method in applications to trace flow of execution then we are able to 
get the following problems.  

1. System.out.println(--) will be used for only console display, not for sending data to any other   
output systems like file systems[html files, xml files, text files...], databases, network,....  

2. System.out.println() method contains synchronized block to display data, it is heavy weight,   
expensive and time consuming.  

3. In Applications, it is not suggestible to write too many no of System.out.println() methods in   
applications, because, it will reduce application performance.  

4. System.out.println() method is usefull in Development environment only, It is not suitable in  
production environment , because, if we use System.out.println() method in server side  
applications then it will display messages in servers console only, it will not be avaiable to users.  

5. System.out.println() will display the messages on console or on command prompt, it will not  
show differences in Error messages, warning messaages, normal information,....  

6. System.out.println() is suitable for simple standalone applications, not for complex  
enterprise applications.  

To overcome all the problems while tracing applications we have to use Logging.  

---------------------------------------------------------------------------------------------------------------------

In general, in java applications, Logging is required   

1. To understand flow of execution in applications  
2. To manage exception messages when Exceptions are occurred in java applications  
3. To manage the event - notification messages in file systems....  

# Logging Framework:  

It is a set of classes and interfaces or a product to perform Logging in Java applications  

EX:  

1. Java provided java.util Logging  
2. Log4j  
3. LogBack  
4. Commons Logging  
5. ObjectGuy  
6. TinyLog  



