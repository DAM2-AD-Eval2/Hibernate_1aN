package com.dam.DAMHibernate_1aN;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Principal {

	public static void main(String[] args) {
		
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		
		
		session.getTransaction().begin();
		
		Conductor c1 = new Conductor("11111111A", "Fulanito", "4324234324");
		Coche coche1 = new Coche("4444ABC", "Toyota", "Yaris", c1);
		Coche coche2 = new Coche("8888XYZ", "Opel", "Corsa", c1);
		
		
		session.save(c1);
		session.save(coche1);
		session.save(coche2);
		
		session.getTransaction().commit();
		
		session.close();
		sf.close();

	}

}
