package com.tao.service;

import java.util.List;

import com.tao.bean.Person;

public interface PersonService {

	public void save(Person person);
	public void update(Person person);
	public void delete(Integer personId);
	public Person getPerson(Integer personid);
	public List<Person> getPersons();
}
