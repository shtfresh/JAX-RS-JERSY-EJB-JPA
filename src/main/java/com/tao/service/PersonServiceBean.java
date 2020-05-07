package com.tao.service;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tao.bean.Person;

@Stateless
@LocalBean
public class PersonServiceBean implements PersonService {
	
	@PersistenceContext(unitName="itcast") EntityManager em;

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
		em.merge(person);
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
