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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UniversityRestApi.dto.StudentDTO;
import com.example.UniversityRestApi.dto.SystemMapper;
import com.example.UniversityRestApi.dto.creation.StudentCreationDTO;
import com.example.UniversityRestApi.entity.Student;
import com.example.UniversityRestApi.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api/v3/students")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private SystemMapper mapper;

	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("studentId") int studentId) {

		StudentDTO studentDto = mapper.studentToStudentDto(studentService.findById(studentId));

		return new ResponseEntity<>(studentDto, HttpStatus.ACCEPTED);
	}

	@PostMapping("")
	public ResponseEntity<?> addStudent(@RequestBody StudentCreationDTO studentCreationDto) {

		Student theStudent = mapper.studentCreationToStudent(studentCreationDto);

		studentService.save(theStudent);

		return new ResponseEntity<>("Data Saved", HttpStatus.ACCEPTED);
	}

	@GetMapping("")
	public ResponseEntity<List<StudentDTO>> getAllStudent() {

		List<StudentDTO> studentsDto = studentService.findAll().stream().map(mapper::studentToStudentDto).toList();

		return new ResponseEntity<>(studentsDto, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{studentId}/{courseId}")
	public ResponseEntity<StudentDTO> assignCoursesToStudent(@PathVariable("studentId") int studentId,
			@PathVariable("courseId") int courseId) {

		StudentDTO studentDto = mapper.studentToStudentDto(studentService.addCoursetoStudent(studentId, courseId));

		return new ResponseEntity<>(studentDto, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("studentId") int studentId) {

		studentService.deleteById(studentId);

		return new ResponseEntity<>("Success Delete Student", HttpStatus.ACCEPTED);
	}

	@PatchMapping("/{studentId}")
	public ResponseEntity<?> updateInstructor(@PathVariable("studentId") int studentId,
			@RequestBody Map<String, Object> fields) {

		studentService.update(studentId, fields);

		return new ResponseEntity<>("Success Update Student", HttpStatus.ACCEPTED);
	}

}
