package com.example.UniversityRestApi.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.UniversityRestApi.entity.Instructor;
import com.example.UniversityRestApi.exc.InstructorNotFoundException;
import com.example.UniversityRestApi.repo.InstructorRepository;
import com.example.UniversityRestApi.service.InstructorService;


@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
		
	@Override
	public Instructor findById(int theId) {
		Optional<Instructor> result = instructorRepository.findById(theId);
		
		Instructor theInstructor = null;
		
		if(result.isPresent()) {
			theInstructor = result.get();
		}
		else {
			throw new InstructorNotFoundException("Instructor Not Found!");
		}
		
		return theInstructor;
	}

	@Override
	public List<Instructor> findAll() {
		
		List<Instructor> instructors = instructorRepository.findAll();
		
		if(instructors.isEmpty()) {
			throw new InstructorNotFoundException("There's No Instructors - 🥲!");
		}
		
		return instructors;
	}

	@Override
	public void deleteById(int theId) {
		
        Optional<Instructor> result = instructorRepository.findById(theId);
			
		if(result.isEmpty()) {
			throw new InstructorNotFoundException("Instructor Not Found!");
		}
		
		instructorRepository.deleteById(theId);
	}

	@Override
	public void save(Instructor theInstructor) {
        instructorRepository.save(theInstructor);
	}

	@Override
	public Instructor update(int theId, Map<String, Object> fields) {
		 
		Optional<Instructor> result = instructorRepository.findById(theId);
			
		if(result.isEmpty()) {
			throw new InstructorNotFoundException("Instructor Not Found!");
		}
				
		Instructor theInstructor = result.get();
		
		fields.forEach((key , val) ->{
			
			Field field = ReflectionUtils.findField(Instructor.class, key);
		    field.setAccessible(true);
			    
		    ReflectionUtils.setField(field, theInstructor, val);
			
		});
		
		instructorRepository.save(theInstructor);
		
		return theInstructor;
	}
}
