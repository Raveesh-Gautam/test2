package com.signup.SignUp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.signup.SignUp.dao.StudentRepository;
import com.signup.SignUp.entities.Login;
import com.signup.SignUp.entities.Student;

@Component
public class Services {
	@Autowired
	private StudentRepository studentRepository;
public Student createStudent(Student st) {
//	Student student=new Student();
//	student.setRollNo(1);
//	student.setName("aakash");
//	student.setEmail("gautam@gmail.com");
//	student.setPassword("abcd");
//	st=student;
	Student student=this.studentRepository.save(st);
	return student;
	

}

public Student loginStatus(Login login) {
	
	Student st=studentRepository.findByPassword(login.getPassword()); 

	return st;
}
}
