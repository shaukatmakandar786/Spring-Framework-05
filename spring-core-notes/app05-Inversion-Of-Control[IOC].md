# Inversion of Control[IOC]:

The IoC container creates an object of the specified class and also injects all the dependency objects through a constructor dependency injection, setter method dependency injection at run time and disposes it at the appropriate time. This is done so that we don't have to create and manage objects manually. 

## there are two ways to achieve dependency injection:

1. Constructor Dependency injecton
2. Setter Method Dependency Injection

## 1. Constructor Dependency injecton

If we inject dependent values to the bean object through Contructor then this type of Dependency injection is called as "Constructor Dependency Injection".

If we want to use constructor dependency injection in spring application,first we have to declared respective parameterized constructor in the corresponding bean class then we have to declared that constructor arguments in spring configuration file by using the following tags.

    <beans>
      <bean...>
        <construct-arg value="---"/>
        <constructor-arg>value</constructor-arg>
      </bean>
    </beans>  
    
# Course.java

    package com.shaukat.beans;

    import org.springframework.beans.factory.InitializingBean;

    public class Course {

        private String cidString;
        private String cnameString;
        private int ccost;

        public Course(String cidString, String cnameString, int ccost) {
            super();
            this.cidString = cidString;
            this.cnameString = cnameString;
            this.ccost = ccost;
        }
        @Override
        public String toString() {
            return "Course [cidString=" + cidString + ", cnameString=" + cnameString + ", ccost=" + ccost + "]";
        }
    }

# Test.java

    package com.shaukat.test;

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.AbstractApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    import com.shaukat.beans.Course;

    public class Test {

        public static void main(String[] args) {

            ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
            Course course=(Course)context.getBean("course");
            System.out.println(course);
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
        <bean id="course" class="com.shaukat.beans.Course">  
            <constructor-arg value="C-111"/>
            <constructor-arg value="JAVA"/>
            <constructor-arg value="5000"/>	
        </bean>

    </beans>
     
# 2. Setter Method Dependency Injection

    If we inject dependency bean values to the Bean through setXXX() methods then it is called as "Setter Method Dependency Injecton".

    To Inject primitive values and String value to the bean then have to use "value" attributes in <property> or <constrcut-arg> tags
    in beans configuration file, but if we want to inject user define data type,that is object reference values then we have to use "ref" 
    attribut in <property> tag or in <construct-arg> tag.

# Account.java

        package com.shaukat.beans;

        public class Account {

            private String accNo;
            private String accName;
            private String accType;
            private long balance;
            public String getAccNo() {
                return accNo;
            }
            public void setAccNo(String accNo) {
                this.accNo = accNo;
            }
            public String getAccName() {
                return accName;
            }
            public void setAccName(String accName) {
                this.accName = accName;
            }
            public String getAccType() {
                return accType;
            }
            public void setAccType(String accType) {
                this.accType = accType;
            }
            public long getBalance() {
                return balance;
            }
            public void setBalance(long balance) {
                this.balance = balance;
            }
            @Override
            public String toString() {
                return "Account [accNo=" + accNo + ", accName=" + accName + ", accType=" + accType + ", balance=" + balance
                        + "]";
            }
        }

# Employee.java

    package com.shaukat.beans;

    public class Employee {

	private String eid;
	private String ename;
	private float esal;
	private String eaddr;
	private Account acc;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", eaddr=" + eaddr + ", acc=" + acc
				+ "]";
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
        <bean id="account" class="com.shaukat.beans.Account">  
            <property name="accNo" value="abc123"/>
            <property name="accName" value="shaukat"/>
            <property name="accType" value="saving"/>
            <property name="balance" value="25000"/>	
        </bean>

        <bean id="emp" class="com.shaukat.beans.Employee">
            <property name="eid" value="E-111"/>
            <property name="ename" value="Zahid"/>
            <property name="esal" value="60000"/>
            <property name="eaddr" value="Pune"/>
            <property name="acc" ref="account"/>

        </bean>

    </beans>
    
# Test.java

    package com.shaukat.test;

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.AbstractApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    import com.shaukat.beans.Account;
    import com.shaukat.beans.Employee;

    public class Test {

        public static void main(String[] args) {

            ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
            Employee emp=(Employee)context.getBean("emp");
            System.out.println(emp);
        }
    }
## output:

	Employee [eid=E-111, ename=Zahid, esal=60000.0, eaddr=Pune, acc=Account [accNo=abc123, accName=shaukat, accType=saving, balance=25000]]
	
# Different types of elements injecting in spring application:

	1. In Spring applicatio if we want to inject User defined data types then we have to use either "<ref>" attribute in <property> tag and
	<construct-arg> tag or we have to use "<ref>" nested tag under "<property>" tag and "<construct-arg>" tag.
	
		<beans>  
			<bean id="--" class="--">
				<property name="--" ref="--"/>
					<ref bean="--"/>
				</property>
			</bean>
		</beans>  
	
	
	2. In Spring applicatio if we want to inject List of elements in bean then we have to declared the corresponding property
	as java.util.List and we have to provide values in configuration fle by using <list> tag in <property> tag or in <construct-arg> tag.
	
		<beans>  
		  <bean id="--" class="--">
		     <property name="--">
			<list>
			  <value>value1</value>
			  <value>value2</value>
			  ---
			  ---
			</list>
		     </property>
		  </bean>
		</beans>
		
	3. In Spring applicatio if we want to inject Set of elements in bean then we have to declared the corresponding property
	as java.util.Set and we have to provide values in configuration fle by using <set> tag in <property> tag or in <construct-arg> tag.	


		<beans>  
		  <bean id="--" class="--">
		     <property name="--">
			<set>
			  <value>value1</value>
			  <value>value2</value>
			  ---
			  ---
			</set>
		     </property>
		  </bean>
		</beans>
		
	3. In Spring applicatio if we want to inject Map of elements in bean then we have to declared the corresponding property
	as java.util.Map and we have to provide Key-Value pair in configuration file by using <map> and <entry> tag in <property> tag or in <construct-arg> tag.	
	
		<beans>  
		  <bean id="--" class="--">
		     <property name="--">
			<map>
			  <entry key="key1" value="value1"/>
			  <entry key="key2" value="value2"/>
			  ---
			  ---
			</map>
		     </property>
		  </bean>
		</beans>
	
	3. In Spring applicatio if we want to inject Properties of elements in bean then we have to declared the corresponding property
	as java.util.Properties and we have to provide Key-Value pair in configuration file by using <props> and <prop> tag in <property> tag or in <construct-arg> tag.
	
		<beans>  
		  <bean id="--" class="--">
		     <property name="--">
			<props>
			  <prop key="key1">value1</prop>
			  <prop key="key2">value2</prop>
			  ---
			  ---
			</props>
		     </property>
		  </bean>
		</beans>
		

# Address.java

	package com.shaukat.beans;

	public class Address {

		private String pno;
		private String street;
		private String city;
		private String country;


		public String getPno() {
			return pno;
		}
		public void setPno(String pno) {
			this.pno = pno;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		@Override
		public String toString() {
			return "Address [pno=" + pno + ", street=" + street + ", city=" + city + ", country=" + country + "]";
		}


	}

# Student.java

	package com.shaukat.beans;

	import java.util.List;
	import java.util.Map;
	import java.util.Properties;
	import java.util.Set;

	public class Student {

		private String sid;
		private String sname;
		private Address saddr;
		private List<String> squal;
		private Set<String> scourses;
		private Map<String,String> scourses_And_Faculty;
		private Properties scourse_And_Cost;


		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public Address getSaddr() {
			return saddr;
		}
		public void setSaddr(Address saddr) {
			this.saddr = saddr;
		}
		public List<String> getSqual() {
			return squal;
		}
		public void setSqual(List<String> squal) {
			this.squal = squal;
		}
		public Set<String> getScourses() {
			return scourses;
		}
		public void setScourses(Set<String> scourses) {
			this.scourses = scourses;
		}
		public Map<String, String> getScourses_And_Faculty() {
			return scourses_And_Faculty;
		}
		public void setScourses_And_Faculty(Map<String, String> scourses_And_Faculty) {
			this.scourses_And_Faculty = scourses_And_Faculty;
		}
		public Properties getScourse_And_Cost() {
			return scourse_And_Cost;
		}
		public void setScourse_And_Cost(Properties scourse_And_Cost) {
			this.scourse_And_Cost = scourse_And_Cost;
		}

		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sname=" + sname + ", saddr=" + saddr + ", squal=" + squal + ", scourses="
					+ scourses + ", scourses_And_Faculty=" + scourses_And_Faculty + ", scourse_And_Cost=" + scourse_And_Cost
					+ "]";
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
	    <bean id="addr" class="com.shaukat.beans.Address">  
			<property name="pno" value="202"/>
			<property name="street" value="M G Road"/>
			<property name="city" value="Banglore"/>
			<property name="country" value="India"/>	
	    </bean>
	    <bean id="std" class="com.shaukat.beans.Student">  
			<property name="sid" value="S-111"/>
			<property name="sname" value="Shaukat"/>
			<property name="saddr" ref="addr"/>
			<property name="squal">	
				<list>
					<value>BTech</value>
					<value>MTech</value>
					<value>PHD</value>
				</list>
			</property>
			<property name="scourses">	
				<set>
					<value>Core Java</value>
					<value>Adv Java</value>
					<value>Spring</value>
					<value>Hibernate</value>
				</set>
			</property>

			<property name="scourses_And_Faculty">	
				<map>
					<entry key="CoreJava" value="Hiren"/>
					<entry key="AdvJava" value="Shubham"/>
					<entry key="Spring" value="Wasim"/>
					<entry key="Hibernate" value="Sajjad"/>
				</map>
			</property>

			<property name="scourse_And_Cost">	
				<props>
					<prop key="Core Java">1500</prop>
					<prop key="Adv Java">2000</prop>
					<prop key="Spring">3000</prop>
					<prop key="Hibernate">3000</prop>
				</props>
			</property>

	    </bean>

	</beans>
	
# Test.java

	package com.shaukat.test;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.AbstractApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	import com.shaukat.beans.Student;
	import com.shaukat.beans.Address;

	public class Test {

		public static void main(String[] args) {

			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			Student std=(Student)context.getBean("std");
			System.out.println(std);
		}
	}
	
	Student [sid=S-111, sname=Shaukat, saddr=Address [pno=202, street=M G Road, city=Banglore, country=India], squal=[BTech, MTech, PHD], scourses=[Core Java, Adv Java, Spring, Hibernate], scourses_And_Faculty={CoreJava=Hiren, AdvJava=Shubham, Spring=Wasim, Hibernate=Sajjad}, scourse_And_Cost={Adv Java=2000, Core Java=1500, Hibernate=3000, Spring=3000}]



# Circular Dependency Injection:

In Spring Application, If more than one object are dependent on each other through constructor dependency injection then it is called as Circular Dependency Injection, which is not supported by Spring Framework,it able to to raise an exception like "org.springfarmework.beans.factory.BeanCurrentlyCreationException"


# Student.java

	package com.shaukat.beans;

	public class Student {

		private Branch branch;

		public Student(Branch branch) {
			super();
			this.branch = branch;
		}
		public String getStudentName()
		{
			return "shaukat";
		}

	}
	
	
# Branch.java

	package com.shaukat.beans;

	public class Branch {

		private Student student;

		public Branch(Student student) {
			super();
			this.student = student;
		}
		public String getBranchName()
		{
			return "MCA";
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
	    <bean id="student" class="com.shaukat.beans.Student">  
			<constructor-arg ref="branch"/>
	    </bean>

	    <bean id="branch" class="com.shaukat.beans.Branch">
		<constructor-arg ref="student"/>
	    </bean>

	</beans>
	
# Test.java

	package com.shaukat.test;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.AbstractApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	import com.shaukat.beans.Student;
	import com.shaukat.beans.Branch;

	public class Test {

		public static void main(String[] args) {

			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			Student std=(Student)context.getBean("student");
			System.out.println(std.getStudentName());
			Branch brch=(Branch)context.getBean("branch");
			System.out.println(brch.getBranchName());
		}
	}

	Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'student' defined in class path resource [beans.xml]: Cannot resolve reference to bean 'branch' while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'branch' defined in class path resource [beans.xml]: Cannot resolve reference to bean 'student' while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'student': Requested bean is currently in creation: Is there an unresolvable circular reference?
	
## Note:

In Spring Application if we want resolve Circular Dependancy Injection then we have to use Setter Method dependency Injection instead of Constructor Dependency Injection.


# Student.java

	package com.shaukat.beans;

	public class Student {

		private Branch branch;

		public Branch getBranch() {
			return branch;
		}

		public void setBranch(Branch branch) {
			this.branch = branch;
		}

		public String getStudentName() {
			return "shaukat";
		}

	}
	
# Branch.java

	package com.shaukat.beans;

	public class Branch {

		private Student student;

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public String getBranchName() {
			return "MCA";
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
	    <bean id="student" class="com.shaukat.beans.Student">  
			<property name="branch" ref="branch"/>
	    </bean>

	    <bean id="branch" class="com.shaukat.beans.Branch">
		<property name="student" ref="student"/>
	    </bean>

	</beans>
	
# Test.java

	package com.shaukat.test;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.AbstractApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	import com.shaukat.beans.Student;
	import com.shaukat.beans.Branch;

	public class Test {

		public static void main(String[] args) {

			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			Student std=(Student)context.getBean("student");
			System.out.println(std.getStudentName());
			Branch brch=(Branch)context.getBean("branch");
			System.out.println(brch.getBranchName());
		}
	}

	/* shaukat  MCA  */



