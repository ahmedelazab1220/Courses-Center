package com.example.UniversityRestApi.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UniversityRestApi.entity.Instructor;
import com.example.UniversityRestApi.entity.InstructorDetail;
import com.example.UniversityRestApi.exc.InstructorDetailNotFoundException;
import com.example.UniversityRestApi.exc.InstructorNotFoundException;
import com.example.UniversityRestApi.repo.InstructorDetailRepository;
import com.example.UniversityRestApi.repo.InstructorRepository;
import com.example.UniversityRestApi.service.InstructorDetailService;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

	@Autowired
	private InstructorDetailRepository instructorDetailRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	@Override
	public InstructorDetail findById(int theId) {
		
		Optional<Instructor> result = instructorRepository.findById(theId);
		
		if(result.isEmpty()) {
			throw new InstructorNotFoundException("Instructor Not Found!");
		}
		
		return result.get().getInstructorDetail();
	}

	@Override
	public List<InstructorDetail> findAll() {
		
		List<InstructorDetail> instructorsDetail = instructorDetailRepository.findAll();
		
		if(instructorsDetail.isEmpty()) {
			throw new InstructorDetailNotFoundException("There's No Instructors Detail Not Found - 🥲!");
		}
		
		return instructorsDetail;
	}

	@Override
	public void deleteById(int theId) {
		Optional<InstructorDetail> result = instructorDetailRepository.findById(theId);
		
		if(result.isEmpty()) {
			throw new InstructorDetailNotFoundException("Instructor Detail Not Found!");
		}
		
		instructorDetailRepository.deleteById(theId);
	}

	@Override
	public InstructorDetail save(int theId , Map<String , Object> fields) {
		
        Optional<Instructor> result = instructorRepository.findById(theId); 
		
        if(result.isEmpty()) {
			throw new InstructorNotFoundException("Instructor Not Found!");
		}
        
        InstructorDetail instructorDetail = new InstructorDetail();
		        
		fields.forEach((key , val) ->{
			switch(key) {
			   case "youtubeChannel": instructorDetail.setYoutubeChannel((String) val); break;
               case "linkedin": instructorDetail.setLinkedin((String) val); break;
               case "facebook": instructorDetail.setFacebook((String) val); break;
               case "github": instructorDetail.setGithub((String) val); break;
               case "hobby": instructorDetail.setHobby((String) val); break;
               default: // Handle unknown fields if necessary
			}
			
		});
		
		if(result.get().getInstructorDetail() == null) {
			result.get().setInstructorDetail(instructorDetail);
		}
		else {
			fields.forEach((key , val) ->{
				switch(key) {
				   case "youtubeChannel": result.get().getInstructorDetail().setYoutubeChannel((String) val); break;
	               case "linkedin": result.get().getInstructorDetail().setLinkedin((String) val); break;
	               case "facebook": result.get().getInstructorDetail().setFacebook((String) val); break;
	               case "github": result.get().getInstructorDetail().setGithub((String) val); break;
	               case "hobby": result.get().getInstructorDetail().setHobby((String) val); break;
	               default: // Handle unknown fields if necessary
				}
				
			});
		}
		
		instructorRepository.save(result.get());
		
		return instructorDetail;
	}

}
