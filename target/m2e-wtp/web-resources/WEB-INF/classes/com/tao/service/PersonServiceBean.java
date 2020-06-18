package com.tao.service;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.tao.bean.Person;
import com.tao.bean.Person;
import com.tao.utl.Convert;

@Stateless
@LocalBean
public class PersonServiceBean implements PersonService {
	
	@PersistenceContext(unitName="weblogic-datasource") EntityManager em;

	public PersonServiceBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		em.persist(person);
	}

	@Override
	
	public void update(Person person) {
		// TODO Auto-generated method stub
		//System.out.print("this is person  "+person);

		
	//	try {
			Person person_db=getPerson(person.getId());
			person_db.setAge(person.getAge());
			person_db.setGender(person.getGender());
			person_db.setHeight(person.getHeight());
			person_db.setName(person.getName());
			em.merge(person_db);
	
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("this is a  problem person"+person);
//			
//		}
	}

	@Override
	public void delete(Integer personId) {
		// TODO Auto-generated method stub
		em.remove(em.getReference(Person.class, personId));
	}

	@Override
	public Person getPerson(Integer personid) {
		// TODO Auto-generated method stub
		return em.find(Person.class,personid);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return em.createQuery("select o from Person o").getResultList();
	}
	

	

}
