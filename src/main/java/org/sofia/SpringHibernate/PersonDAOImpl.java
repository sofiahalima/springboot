package org.sofia.SpringHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonDAOImpl implements PersonDAO{
	
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
		
	}

	public List<Person> getAllPerson() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Person> personList=session.createQuery("from Person").list();
		tx.commit();
		session.close();
		return personList;
	}
	

}
