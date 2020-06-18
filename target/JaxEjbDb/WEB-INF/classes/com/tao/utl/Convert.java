package com.tao.utl;

import com.tao.bean.Person;


public class Convert {

	public Convert() {
		// TODO Auto-generated constructor stub
	}
	
	public static Person convertPerson2PersonEjb(Person person) {
		Person personEjb = new Person();
		personEjb.setAge(person.getAge());
		personEjb.setGender(person.getGender());
		personEjb.setHeight(person.getHeight());
		personEjb.setId(person.getId());
		personEjb.setName(person.getName());
		return personEjb;
	}

}
