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

# In Building MAVEN Projects, pom.xml file contains the following configurations.

1. Project Description
2. Repository
3. Dependency Management
4. Project Inheritance
5. Build Configuration
6. Build Profiles

# 1. Project Description:

In pom file, initial we will identify "Projection Description", it contains Project name, version
number, packaged type,.....  

To specify the above details, we need to use the following XML tags.  

    <project ..... >
    <!-- Project Description -->
    <modelVersion> --- </modelVersion>
    <groupid> --- </groupid>
    <artifactid> -- </artifactid>
    <version> -- </version>
    -----
    -----
    </project>


    Where "<project>" tag is root tag in pom.xml file  
    Where "<modelVersion>" tag declared which version of the MAVEN we are  
    using.<modelVersion> tag will take 4.0.0 to support for MAVEN2.x/3.x versions.  
    Where "<groupid>" tag will take an unique ID for an organization, or a project.Normally we
    use a group ID similar to the root Java package name of the project.  
    Where "<artifactid>" tag will take name of the project.The artifact ID is used as name for a
    sub directory under the group ID directory in the Maven repository and as part of the
    name of the JAR file produced when
    building the project.The build result, a JAR, WAR
    or EAR file, is called an artifact in Maven.  
    Where "<versin>" tag will take Project version number.  
    Where "<packaging>" tag will take different packaging formats inorder to delivery the
    project like jar, war, ear,...  
