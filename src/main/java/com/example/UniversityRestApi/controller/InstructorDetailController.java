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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UniversityRestApi.dto.InstructorDetailDTO;
import com.example.UniversityRestApi.dto.Mapper;
import com.example.UniversityRestApi.service.impl.InstructorDetailServiceImpl;


@RestController
@RequestMapping("/api/v3/instructorDetail")
public class InstructorDetailController {

	@Autowired
	private InstructorDetailServiceImpl instructorDetailService;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping("/{instructorId}")
	public ResponseEntity<InstructorDetailDTO> findInstructorDetail(@PathVariable("instructorId") int instructorId){
		
		InstructorDetailDTO instructorDetailDto = mapper.toInstructorDetailDTO(instructorDetailService.findById(instructorId));
		
		return new ResponseEntity<>(instructorDetailDto , HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/{instructorId}")
	public ResponseEntity<?> updateInstructorDetail(@PathVariable("instructorId") int instructorId , @RequestBody Map<String , Object> fields){
		
		instructorDetailService.save(instructorId, fields);
		
		return new ResponseEntity<>("Update Data" , HttpStatus.ACCEPTED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<InstructorDetailDTO>> findAllInstructorDetail(){
		
		List<InstructorDetailDTO> instructorsDetailDto = instructorDetailService.findAll().stream().map(mapper::toInstructorDetailDTO).toList();
		
		return new ResponseEntity<>(instructorsDetailDto , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{instructorDetailId}")
	public ResponseEntity<?> deleteInstructorDetail(@PathVariable("instructorDetailId") int instructorDetailId){
		
		instructorDetailService.deleteById(instructorDetailId);
		
		return new ResponseEntity<>("Success Delete InstructorDetail" , HttpStatus.ACCEPTED);
	}
	
}
