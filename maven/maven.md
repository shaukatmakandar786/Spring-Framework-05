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
    
    
    <project ..... >
     <!-- Project Description --
     <modelVersion>4.0.0</modelVersion>
      <groupid>com.durgasoft.banking</groupid>
      <artifactid>icici.accounts</artifactid>
      <version>1.0</version>
      <name>Account Application</name>
      <description> Application for Accounts module in icici Bank project </description>
      -----
    </project>
    
# 2) Repository:

If we use Dependencies in MAVEN Project then MAVEN will search for the dependent JARs in
Repositories.  

MAVEN will use three types of Repositories in order to get dependencies.  

## 1. Local Repository:

It is a location to manage and supply all dependencies, it will be created by MAVEN when we
execute any MAVEN command first time.  

In general, MAVEN will create Local Repository at "C:/Users/User_Name/.m2/repository"
EX: C:\Users\LENOVO\.m2\repository.  

## 2. Central Repository:

It is a default Repository for MAVEN, it is located at "http://repo1.maven.org/maven2".  

IN MAVEN applications, we will use some other repositories are also explicitly like.  

1. "http://repository.jboss.org/nexus/content/groups/public"
2. "http://mvnrepository.com"  

         In MAVEN applications, if we want to use the above explict repositories then we have to configure
         them in pom file by using the following xml tags.  


         <repositories>
               <repository>
                 <id>jboss</id>
                 <name>jboss repo</name>
                 <url>http://repository.jboss.org/nexus/content/groups/public/</url>
               </repository>
            </repositories>
            
            
## 3. Remote Repository:

In some Situations, Maven does not find the dependencies in Local Repository and in central
repository, in this context, MAVEN stops the build process and generates some Exceptions. To
overcome this problems, Maven has provided a new Features like "Remote Repository".  

Remote Repository is a developer's own custom repository containing required libraries or other
project jars.  

To configure Remote Repository, we have to use the following XML tags in pom.xml file.  

     <repositories>
       <repository>
         <id>durgasoft.lib</id>
         <url>http://library.durgasoft.com/maven2/lib</url>
       </repository>
     </repositories> 


When we run MAVEN project then MAVEN will search for the dependencies in the following order.  

1) First, MAVEN will search for the dependencies in local repository, if the required
dependencies are available at Local Repository the MAVEN will use them in application. If
the dependencies are not available at Local Repository then MAVEN search for them at
Central Repository.

2) If the required Dependencies are existed in central repository then MAVEN will load them
into Local Repository and MAVEN will use them in the applications. If the required
dependencies are not existed in Central Repository then MAVEN will search for them in
Remote Repositories as per configuration.

3) If Remote Repository is not configured then MAVEN will stop the application execution and
generated some Exceptions.
In Applications, Dependencies are the libraries[Collection of JARs] which are required to compile,
test and run our applications.

4) If Remote Repository is configured then MAVEN will search for the required dependencies
in Remote Repository, if they are identified then MAVEN will load them into Local
Repository for futur reference. If the dependencies are not existed at Remote Repositories
then MAVEN will stop the execution and generate some Exceptions.  

# 3) Dependency Management:

In Applications, Dependencies are the libraries[Collection of JARs] which are required to compile,
test and run our applications.  

In General, in application development, we will download the required libraries from internet and
we will store them in application directory structer.  

The main Advantage of MAVEN in applications development is that not to store any Dependent
JAR files in Project Directory Structer by downloading them explicitly, MAVEN has given flexibility
to the developers like to specify dependent JAR files names in pom file, where MAVEN will search
for them in the repositories and MAVEN will load them into the project directory structer
automatically.  

If we need any Library in MAVEN based applications then we have to declare them in pom file like
below.  

     < dependencies>
       <dependency>
         <groupId>org.hibernate</groupId>
         <artifactId>hibernate-core</artifactId>
         <version>3.5.6-Final</version>
         <scope>provided</scope>
       </dependency>
     </dependencies>
     
    If we provide the dependency like above then MAVEN will search for the hibernate library with the name like
    http://repo1.maven.org/maven2/org/hibernate/hibernate-core/3.5.6-Final/  

    MAVEN is following "Transitive Dependencies Mechanism", that is, if our dependencies are
    required any other libraries then MAVEN will get them automatically without loading them explicitly
    by the developers.    
    
## Dependency Scopes:

In Applications, some dependencies are required to all phases of the project lifecycle like compile,
test, run,... and some other required only some of phases of the project lifecycle.  

In order to limit the dependencies for the lifecycle phases we will use Dependency Scopes.  

There are 6 scopes available in MAVEN  

1. Compile
2. Provided
3. Runtime
4. Test
5. System
6. Import

## 1. Compile:

It is the default scope in MAVEN . This scope will make the dependencies to avail all phases like
compile, test, run,....  

    < dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>3.5.6-Final</version>
      <scope>compile</scope>
    </dependency>

    Note: In general, hibernate-core library is required for all phases of the application.
    
    
## 2. Provided:

This scope will make the dependency libraries to avail upto compilation and and upto testinbg, not
for runtime, because, at runtime, JDKs or Containers will provide the required dependencies at
runtime.  

EX:  

In web applications, Servlet API is required expliclty to compile and test the project, but, Servlet
API is provided by the container at runtime automatically, so that, they are not required to be
exported at runtime.  

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>3.0.1</version>
      <scope>provided</scope>
    </dependency>

## 3. Runtime:

This scope indicates that the dependency is not required for compilation, but is for execution. It is
in the runtime and test class paths, but not the compile class path.  

    EX:  

    <dependency>
       <groupId>com.thoughtworks.xstream</groupId>
       <artifactId>xstream</artifactId>
       <version>1.4.4</version>
       <scope>runtime</scope>
    </dependency>  
    
## 4. Test:

This scope indicates that the dependency is not required for normal use of the application, and is
only available for the test compilation and execution phases. This scope is not transitive.  

    EX:  

    <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.12</version>
       <scope>test</scope>
    </dependency>
    
## 5. System:

Dependencies with system are similar to ones with scope provided. The only difference is system
dependencies are not retrieved from remote repository. They are present under project‘s
subdirectory and are referred from there.  

    <dependency>
       <groupId>Explicit_Dependency</groupId>
       <artifactId>Explicit_Dependency</artifactId>
       <scope>system</scope>
       <version>1.0</version>
       <systemPath>apps\app.war\WEB-INF\lib\Explicit_Dependency.jar</systemPath>
    </dependency>
    
## 6. Import:

It is available in Maven 2.0.9 or later.
Import scope is only supported on a dependency of type pom in the dependencyManagement
section. It indicates the dependency to be replaced with the effective list of dependencies in the
specified POM‘s dependencyManagement section.  

    EX:  

    <dependencyManagement>
      <dependencies>
        <dependency>
           <groupId>other.pom.group.id</groupId>
           <artifactId>other-pom-artifact-id</artifactId>
           <version>SNAPSHOT</version>
           <scope>import</scope>
           <type>pom</type>
        </dependency>
      </dependencies>
    </dependencyManagement>  

# 4) Project Inheritance:

In MAVEN based applications, it is possible to inherit configurations from one pom file to another
pom file inorder to avoid configurations redundency.  

To declare parent pom , we have to use "pom" as value to <packaging> tag in parent pom file.  
 
                
