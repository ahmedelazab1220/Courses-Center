package com.example.UniversityRestApi.service;

import java.util.List;
import java.util.Map;

import com.example.UniversityRestApi.entity.InstructorDetail;

public interface InstructorDetailService {
   
    public InstructorDetail findById(int theId);
	
	public List<InstructorDetail> findAll();
	
	public void deleteById(int theId);
	
	public InstructorDetail save(int theId , Map<String , Object> fields);
		
}
