package com.example.UniversityRestApi.service;

import java.util.List;
import java.util.Map;

import com.example.UniversityRestApi.entity.Course;

public interface CourseService {

    public Course findById(int theId);
	
	public List<Course> findAll();
	
	public void deleteById(int theId);
	
	public void save(Course theCourse);
	
	public Course update(int theId , Map<String, Object> fields);
			
}
