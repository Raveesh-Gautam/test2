package com.signup.SignUp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.signup.SignUp.entities.Login;
import com.signup.SignUp.entities.Student;
import com.signup.SignUp.service.Services;

@RestController
public class SignUpController {
	@Autowired
	private Services services;
@PostMapping(path="/signup")
	public ResponseEntity<Student> AddUser(@RequestBody Student student) {
//	return services.createStudent(student);
	Student res=null;
	try {
	res=services.createStudent(student);

	return ResponseEntity.of(Optional.of(res));
	} catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
		
	} 

@PostMapping(path="/login")
public ResponseEntity<String> login(@RequestBody Login login) {
	try {
	String data=login.getPassword();
	Student st=services.loginStatus(login); 
	if(st.getPassword().equals(data)  && login!=null) {
		return ResponseEntity.ok("Login successful");
	}
	
	else {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid data");
	}
	}catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid data");
	}
}
}
