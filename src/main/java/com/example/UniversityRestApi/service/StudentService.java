package com.example.UniversityRestApi.service;

import java.util.List;
import java.util.Map;

import com.example.UniversityRestApi.entity.Student;

public interface StudentService {

    Student findById(int theId);
	
	List<Student> findAll();
	
	void deleteById(int theId);
	
	void save(Student theStudent);
	
	Student addCoursetoStudent(int studentId , int courseId);
	
	Student update(int theId , Map<String , Object> fields);
	
}
