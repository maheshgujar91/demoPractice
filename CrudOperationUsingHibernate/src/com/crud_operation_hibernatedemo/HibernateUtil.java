package com.crud_operation_hibernatedemo;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQL5Dialect;



public class HibernateUtil {

	public static SessionFactory getsessionFactory(){
	
		Map<String,Object> settings=new HashMap<String,Object>();
		settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hiber_crud_operation");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "root");
		settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
		settings.put(Environment.HBM2DDL_AUTO, "update");
		settings.put(Environment.SHOW_SQL,"true" );
		
	StandardServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(settings).build();
	
	MetadataSources mds=new MetadataSources(registry).addAnnotatedClass(Student.class);
	
	Metadata md=mds.getMetadataBuilder().build();
	
	SessionFactory sf=md.getSessionFactoryBuilder().build();
	

	return sf;
	}
	
}
