package com.example.UniversityRestApi.service;

import java.util.List;
import java.util.Map;

import com.example.UniversityRestApi.entity.Instructor;

public interface InstructorService {
	
	public Instructor findById(int theId);
	
	public List<Instructor> findAll();
	
	public void deleteById(int theId);
	
	public void save(Instructor theInstructor);
	
	public Instructor update(int theId , Map<String , Object> fields);
	
}
