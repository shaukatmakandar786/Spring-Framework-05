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
