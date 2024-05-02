package com.example.UniversityRestApi.service;

import java.util.List;
import java.util.Map;

import com.example.UniversityRestApi.entity.Instructor;

public interface InstructorService {
	
	Instructor findById(int theId);
	
	List<Instructor> findAll();
	
	void deleteById(int theId);
	
	void save(Instructor theInstructor);
	
	Instructor update(int theId , Map<String , Object> fields);
	
}
