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

import com.example.UniversityRestApi.dto.InstructorDTO;
import com.example.UniversityRestApi.dto.SystemMapper;
import com.example.UniversityRestApi.dto.creation.InstructorCreationDTO;
import com.example.UniversityRestApi.entity.Instructor;
import com.example.UniversityRestApi.service.impl.InstructorServiceImpl;


@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

	@Autowired
	private InstructorServiceImpl instructorService;
	
	@Autowired
	private SystemMapper mapper;
	
	
	@GetMapping("")
	public ResponseEntity<List<InstructorDTO>> getAllInstructors(){
		
		List<InstructorDTO> instructorsDto = instructorService.findAll().stream().map(mapper::instructorToInstructorDto).toList();
		
		return new ResponseEntity<>(instructorsDto , HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/{instructorId}")
	public ResponseEntity<InstructorDTO> getInstructor(@PathVariable("instructorId") int instructorId){
		
        InstructorDTO instructorDto = mapper.instructorToInstructorDto(instructorService.findById(instructorId));
		
		return new ResponseEntity<>(instructorDto , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{instructorId}")
	public ResponseEntity<String> deleteInstructor(@PathVariable("instructorId") int instructorId) { 
		
		instructorService.deleteById(instructorId);
		
		return new ResponseEntity<>("Success Delete Instructor" , HttpStatus.ACCEPTED);
	}
		
	@PostMapping("")
	public ResponseEntity<?> addInstructor(@RequestBody InstructorCreationDTO instructorCreationDto) {
		
		Instructor theInstructor = mapper.instructorCreationToInstructor(instructorCreationDto);

		instructorService.save(theInstructor);
		
		return new ResponseEntity<>("Data Saved" , HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/{instructorId}")
	public ResponseEntity<?> updateInstructor(@PathVariable("instructorId") int instructorId , @RequestBody Map<String , Object> fields){
		
		instructorService.update(instructorId, fields);
		
		return new ResponseEntity<>("Success Update Instructor", HttpStatus.ACCEPTED);
	}
	
}
