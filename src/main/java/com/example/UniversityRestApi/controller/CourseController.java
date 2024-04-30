package com.example.UniversityRestApi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UniversityRestApi.dto.CourseDTO;
import com.example.UniversityRestApi.dto.Mapper;
import com.example.UniversityRestApi.dto.creation.CourseCreationDTO;
import com.example.UniversityRestApi.entity.Course;
import com.example.UniversityRestApi.service.impl.CourseServiceImpl;
import com.example.UniversityRestApi.service.impl.InstructorServiceImpl;


@RestController
@RequestMapping("/api/v2/courses")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseService;
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private InstructorServiceImpl instructorService;
	
	
	@GetMapping("")
	public ResponseEntity<List<CourseDTO>> getAllCourses(){
		
        List<CourseDTO> coursesDto = courseService.findAll().stream().map(mapper::toCourseDTO).toList();
		
		return new ResponseEntity<>(coursesDto , HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable("courseId") int courseId){
		
		CourseDTO courseDto = mapper.toCourseDTO(courseService.findById(courseId));
		
		return new ResponseEntity<>(courseDto , HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{instructorId}")
    public ResponseEntity<?> addCourse(@PathVariable("instructorId") int instructorId , @RequestBody CourseCreationDTO courseCreationDto){
		
        Course theCourse = mapper.toCourse(courseCreationDto);
        theCourse.setTheInstructor(instructorService.findById(instructorId));
        
        theCourse.setId(0);
        
        courseService.save(theCourse);
		
		return new ResponseEntity<>("Data Saved" , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable("courseId") int courseId){
		
        courseService.deleteById(courseId);
		
		return new ResponseEntity<>("Success Delete Course", HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable("courseId") int courseId , @RequestBody Map<String , Object> fields){
		
        courseService.update(courseId, fields);
		
		return new ResponseEntity<>("Success Update Course", HttpStatus.ACCEPTED);
	}
	
}
