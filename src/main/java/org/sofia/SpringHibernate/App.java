package org.sofia.SpringHibernate;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		PersonDAO pdao=context.getBean(PersonDAO.class);
		Person person = new Person();
		person.setName("Chris Hemsworth");
		person.setCountry("Australia");
		pdao.save(person);
		System.out.println("Person::"+person);
		List<Person> list =pdao.getAllPerson();
		for(Person p : list){
		 System.out.println("Person list::"+p);
		}
		context.close();

	}
		
}