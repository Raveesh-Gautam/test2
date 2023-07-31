package com.signup.SignUp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
public Student( String name, String email, String password) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
	}


private String name;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
@Column(unique=true)
private String email;
@Id
@Column(nullable=false,unique=true)
private String password;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Student [ name=" + name + ", email=" + email + ", password=" + password + "]";
}
}
