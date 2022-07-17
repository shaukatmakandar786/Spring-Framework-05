# Introduction:

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

## Advantages of Logging Frameworks:  

### 1. Problem diagnosis: 
In ingeneral, in application development, we are able to detect the   
problems which are occurred in compilation time or in execution, but, some hidden problems are  
existed inside the applications, which may not come in out side direcly, but, they will give effect to   
our application execution, in this situation, if we use good Logging Framework then it is possible to   
detect the hidden problems quickly and we can fix them easily.  

### 2. Quick Debugging: 
Once if we diagnose the problem and if we identify the location of the  
problem by using logging framework then it is very simple to fix that problem and it simplifies  
Debugging and it able to reduce overall Debugging time.  

### 3. Easy Maintenance: 
If we provide good Logging Framework to perform logging in our  
applications then it will provide somde description or information about our application which is  
usefull to manage our applications easily.  

### 4. History: 
In general, all Logging Frameworks are tracing the applications flow of execution and  
they are able to store tracing details in a file system, this logging details are usefull to analyze the  
problems and to solve the problems.  

### 5. Cost and Time Saving: 
Logging Frameworks will simplifies debugging, easy maintenance , persisting application information,..... ,  
these qualities of Logging Framework saves time and cost of the application.  

## Drawbacks with Logging Frameworks:

1. Logging Frameworks needs to write some extra code in our java applications, it will increase overhead to the application.  

2. Logging Frameworks will provide some extra code in our applications, it will increase application execution time at runtime, it will reduce application performance.  
3. Logging Framework will provide some extra code in application, so that, it will increase application length.  

4. Poor logging strategies will increase confusion to the developers.  

# Log4j:

Log4J is a reliable, fast and flexible framework written in JAVA to perform logging in Java 
applications and it is provided by Apache Software Foundations.  

## Log4j Features:  

1. Log4j is able to allow more than one thread at a time with out providing data inconsistency 
,so that, Log4j is thread-safe.  

2. Log4j will not slow down the application execution, it will be optimized to improve 
application performance.  

3. Log4j is providing environment to send logging messages to more than one output 
appenders .  

4. Log4j supports internationalization.  

5. Log4j is providing services for both predefined and user defined facilities, it able to provide 
some customizations also.  

6. Log4j allows to set logging behaviours at runtime through the configuration file.  

7. Log4j is providing very good environment to traace Exceptions from its root.
Log4j uses multiple levels like ALL, TRACE, DEBUG, INFO, WARN, ERROR and FATAL to 
generate messages.  

8. Log4j allows to change the format of log output by extending Layout class.
Log4j is using appenders to generate log messages.  

9. Log4j Arch contains mainly the following Objects:  

1. Logger  
2. Appender  
3. Layout  
4. Level  
5. LogManager  
6. Filter  
7. ObjectRender  

### 1. Logger:

This Object is responsibile to get logging messages from Java applications  

### 2. Appender:

The main intention of Appender object is to get logging messages from Logger object and  
publishing that logging messages to the preffered destinations. Each and Every Appender Object  
must have atleast one Destination object inorder to send logging messages.  

EX: ConsoleAppender is able to store logging messages on Console.  

### 3. Layout:  

The main intention of Layout object is to format logging messages in different styles.Layout Object  
is used by Appender object just before publishing Logging Messages.  

### 4. Level:  

The main intention of Level object is to define granualarity and priority of any Logging information.
Each and every Logging information must be with a particular Logging Level.  

Log4j API has provided the following Levels to the Logging messages.

1. ALL  
2. TRACE  
3. DEBUG  
4. ENFO  
5. WRAN  
6. ERROR  
7. FATAL  
8. OFF  

Log4j is giving priorities for the logging messages in the following order.  
ALL >TRACE > DEBUGG > INFO > WARN > ERROR > FATAL>OFF  

### 5. LogManager

LogManager is the central component , it able to manage Log4j framework, it will read all the initial  
configuration details from the configuration file and stored the Logger objects in namespace  
hierarchy with a particular reference name for futer reference. If our application access any Logger  
object on the basis of the reference name then LogManager will return the existed Logger object  
otherwise it will create new Logger object and return to the application.  

### 6. Filter:

The main intention of Filter object is used to analyze logging information and takes the decision  
whther the messages must be logged or not.  

An Appender object may have no of Filter objects, they must approve our logging message before  
publishing logging messages in destination. 

### 7. ObjectRender:  

This Object will be used by Layout object in order to get string representation of the several  
objects which are passed through Log4j framework.  
..


