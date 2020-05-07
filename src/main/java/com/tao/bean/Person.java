package com.tao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name="PERSON")
public class Person {


private Integer id;
private String name;
private String gender;
private Integer age;
private Integer height;

@Id @Column(name="ID") @GeneratedValue(strategy=GenerationType.AUTO)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Column(name="NAME")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Column(name="GENDER")
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
@Column(name="AGE")
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
@Column(name="HEIGHT")
public Integer getHeight() {
	return height;
}
public void setHeight(Integer height) {
	this.height = height;
}


	
}
