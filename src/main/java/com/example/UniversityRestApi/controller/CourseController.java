package com.example.UniversityRestApi.controller;

import com.example.UniversityRestApi.dto.CourseDTO;
import com.example.UniversityRestApi.dto.SystemMapper;
import com.example.UniversityRestApi.dto.creation.CourseCreationDTO;
import com.example.UniversityRestApi.entity.Course;
import com.example.UniversityRestApi.entity.Instructor;
import com.example.UniversityRestApi.service.impl.CourseServiceImpl;
import com.example.UniversityRestApi.service.impl.InstructorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v2/courses")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseService;
	
	@Autowired
    private SystemMapper mapper;
	
	@Autowired
	private InstructorServiceImpl instructorService;
	
	@GetMapping("")
	public ResponseEntity<List<CourseDTO>> getAllCourses(){
		
        List<CourseDTO> coursesDto = courseService.findAll().stream().map(mapper::courseToCourseDto).toList();
		
		return new ResponseEntity<>(coursesDto , HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable("courseId") int courseId){
		
		Course theCourse = courseService.findById(courseId);

		CourseDTO courseDto = mapper.courseToCourseDto(theCourse);
		
		return new ResponseEntity<>(courseDto , HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{instructorId}")
    public ResponseEntity<?> addCourse(@PathVariable("instructorId") int instructorId , @RequestBody CourseCreationDTO courseCreationDto){
		
        Instructor theInstrcutor =  instructorService.findById(instructorId);
		
        Course theCourse = mapper.courseCreationToCourse(courseCreationDto);
           
        theCourse.setTheInstructor(theInstrcutor);
        
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
