package com.shaukat.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import com.shaukat.entity.Employee;

public class Test {

	
	public static void main(String[] args) {
		Session session=null;
		SessionFactory sessionFactory=null;
		Transaction transaction=null;
		try
		{
			Configuration cfg=new Configuration();
			cfg.configure("/hibernate-app01/src/com/shaukat/resourses/hibernate.cfg.xml");
			sessionFactory=cfg.buildSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Employee emp=new Employee();
			emp.setEno(111);
			emp.setEname("AAA");
			emp.setEsal(5000);
			emp.setEaddr("Pune");
			session.save(emp);
			transaction.commit();
			System.out.println("Employee inserted successfully");
			System.out.println("Transaction Success");
			
		}
		catch(Exception e)
		{
			transaction.rollback();
			System.out.println("Transaction failure");
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}
	}

}
