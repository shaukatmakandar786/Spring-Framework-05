# Introduction:

1. Maven is a "Yiddish"[German language] word meaning "Accumulator Of Knowledge".  
2. Maven was originally designed to simplify building processes in Jakarta Turbine project.  
There were several projects and each project contained slightly different ANT build files.  
JARs were checked into CVS.  
3. Apache group then developed Maven which can build multiple projects together, publish
projects information, deploy projects, share JARs across several projects and help in
collaboration of teams  
4. MAVEN is a "Project Management Framework", it is much more than a simple Build tool, its
declarative and standard approach simplifies many aspects of the Project Lifecycle.
The main Objective of MAVEN is  
 
* A comprehensive model for projects, which is reusable, maintainable, and easier to
comprehend [Understand].  

* Plugins or tools that interact with this declarative model.  
MAVEN follows "Convention over Configuration" Principle, which means that developers are not
required to  
create build process themselves, Developers do not have to mention each and  
every configuration detail. Maven provides sensible default behavior for projects.  

MAVEN does the following activities of the project lifecycle automatically.  
* Provides default Project Structer  
* Download Required Dependencies [Jars files]  
* Compiles Source code  
* Packaging projects as .jar, .war, .ear,....  
* Starts Server  
* Deploying Projects into Servers.  
* Perform Unit Testing  
* Preparing Test Reports.  
* Preparing Documentations  
* Undeploy applications from Servers  
* Stops Server.

![pom.png](https://github.com/shaukatmakandar786/Spring-notes-images/blob/main/pom.png)  

1. POM Stands for Project Object Model.
2. POM is the fundamental unit in Maven.
3. POM is an XML file that contains information about the project and configuration details used by Maven to build the project.
4. POM contains default values for projects ike build directory, which is target; the source directory, which is src/main/java; the test source directory, which is src/test/java; and so on.
5. In MAVEN1 , name of pom file is "project.xml", in MAVEN2 it was renamed to pom.xml.
6. When we execute MAVEN project then MAVEN will look for the project configurations in pom.xml file and gets the needed things and executes the project.

