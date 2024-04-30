package com.example.UniversityRestApi.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.example.UniversityRestApi.entity.Course;
import com.example.UniversityRestApi.exc.CourseNotFoundException;
import com.example.UniversityRestApi.repo.CourseRepository;
import com.example.UniversityRestApi.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository; 
	
	@Override
	public Course findById(int theId) {
		Optional<Course> result = courseRepository.findById(theId); 
		
		Course theCourse = null;
		if(result.isPresent()) {
			theCourse = result.get();
		}
		else {
			throw new CourseNotFoundException("Course Not Found!");
		}
	
		return theCourse;
	}

	@Override
	public List<Course> findAll() {
		
		List<Course> courses = courseRepository.findAll();
		
		if(courses.isEmpty()) {
			throw new CourseNotFoundException("There's No Courses - 🥲!");
		}
		
		return courses;
	}

	@Override
	public void deleteById(int theId) {
        Optional<Course> result = courseRepository.findById(theId); 
		
		if(result.isEmpty()) {
			throw new CourseNotFoundException("Course Not Found!");
		}
		
		courseRepository.deleteById(theId);
	}

	@Override
	public void save(Course theCourse) {
       courseRepository.save(theCourse);
	}

	@Override
	public Course update(int theId , Map<String, Object> fields) {
        
		Optional<Course> result = courseRepository.findById(theId); 
		
		if(result.isEmpty()) {
			throw new CourseNotFoundException("Course Not Found!");
		}
		
		Course theCourse = result.get();
		
		fields.forEach((key , value) ->{
		    Field field = ReflectionUtils.findRequiredField(Course.class, key);
		    field.setAccessible(true);
		    ReflectionUtils.setField(field, theCourse, value);
		});
		
		courseRepository.save(theCourse);
		
		return theCourse;
	}
	
}
