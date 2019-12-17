package com.crud_operation_hibernatedemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Operation {

	Scanner sc=new Scanner(System.in);
	
	SessionFactory sf=HibernateUtil.getsessionFactory();
	
	Student s=new Student();
	     Session session=sf.openSession();
	public void a1(){
		System.out.println("Enter Roll of Student");
		int rn=sc.nextInt();
		 s.setRollno(rn);
		 System.out.println("Enter Name of Student");
		 String nm=sc.next();
		 s.setName(nm);
		 System.out.println("Enter Address of Student");
		 String ad=sc.next();
		 s.setAddress(ad);
		
		 session.save(s);
		 session.beginTransaction().commit();
		 
	}     
	     
	public void v1(){
		System.out.println("Below Are the Details Available in the Syatem Database Right-now");
		String hql="from Student";
		Query q=session.createQuery(hql);
		
		List<Student> l=q.getResultList();
		
		for(Student st:l){
			
			System.out.println(st.getRollno());
			System.out.println(st.getName());
			System.out.println(st.getAddress());
		}
	}
	public void u1(){
		System.out.println("To Enter new Details or To Update Existing Contact Please Enter Roll No:-");
		int nrn=sc.nextInt();
		Student s=session.get(Student.class,nrn );
		/*String hql="update Student set Name=?, Address=? where Rollno=?";
		//System.out.println(hql);
		Query q=session.createQuery(hql);*/
        System.out.println("Enter Name to update or Add new Details");
		String nnm=sc.next();
		s.setName(nnm);
		System.out.println("Enter Address to update or Add new Details");
		String nad=sc.next();
		s.setAddress(nad);
		/*System.out.println("To Enter new Details or To Update Existing Contact Please Enter Roll No:-");
		int nrn=sc.nextInt();
		s.setRollno(nrn);*/
		session.saveOrUpdate(s);
		
        session.beginTransaction().commit();		
	}
	public void d1(){
		//String hql="delete from Student where Rollno=?";
		//System.out.println(hql);
		//Query q=session.createQuery(hql);
		System.out.println("Enter Roll to delete details");
		int drn=sc.nextInt();
		Student s=session.get(Student.class, drn);
		
		
		session.delete(s);
		session.beginTransaction().commit();
	}	
}
