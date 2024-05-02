package com.example.UniversityRestApi.service;

import java.util.List;
import java.util.Map;

import com.example.UniversityRestApi.entity.Course;

public interface CourseService {

    Course findById(int theId);
	
	List<Course> findAll();
	
	void deleteById(int theId);
	
	void save(Course theCourse);
	
	Course update(int theId, Map<String, Object> fields);
			
}
