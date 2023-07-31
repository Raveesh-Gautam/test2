package com.signup.SignUp.dao;


import org.springframework.data.repository.CrudRepository;

import com.signup.SignUp.entities.Student;

public interface StudentRepository extends CrudRepository<Student,String>{
public Student findByPassword(String password);
}
