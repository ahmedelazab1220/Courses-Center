package com.example.UniversityRestApi.dto;

import org.springframework.stereotype.Component;

import com.example.UniversityRestApi.dto.creation.CourseCreationDTO;
import com.example.UniversityRestApi.dto.creation.InstructorCreationDTO;
import com.example.UniversityRestApi.dto.response.InstructorCourse;
import com.example.UniversityRestApi.entity.Course;
import com.example.UniversityRestApi.entity.Instructor;
import com.example.UniversityRestApi.entity.InstructorDetail;

@Component
public class Mapper {

	public InstructorDTO toInstructorDto(Instructor theInstructor) {
        return new InstructorDTO(theInstructor.getFirstName() , theInstructor.getLastName() , theInstructor.getEmail() , theInstructor.getPhoneNumber() , theInstructor.getInstructorDetail() , theInstructor.getCourses());
    }

    public Instructor toInstructor(InstructorCreationDTO InstructorDto) {
        return new Instructor(InstructorDto.firstName(), InstructorDto.lastName(), InstructorDto.email() , InstructorDto.phoneNumber());
    }
    
    public InstructorCourse toInstructorCourse(Instructor theInstructor) {
    	return new InstructorCourse(theInstructor.getFirstName() , theInstructor.getLastName() , theInstructor.getEmail() , theInstructor.getPhoneNumber() , theInstructor.getInstructorDetail());
    }
    
    public CourseDTO toCourseDTO(Course theCourse) {
    	return new CourseDTO(theCourse.getCourseName() , theCourse.getPrice(), theCourse.getPublicationDate() , toInstructorCourse(theCourse.getTheInstructor()));
    }
    
    public Course toCourse(CourseCreationDTO courseCreationDTO) {
    	return new Course(courseCreationDTO.courseName() , courseCreationDTO.price() , courseCreationDTO.publicationDate());
    }
    
    public InstructorDetailDTO toInstructorDetailDTO(InstructorDetail instructorDetail) {
    	if(instructorDetail == null) return new InstructorDetailDTO(null, null, null, null, null);
    	return new InstructorDetailDTO((instructorDetail.getYoutubeChannel() == null ? null : instructorDetail.getYoutubeChannel())  , instructorDetail.getLinkedin(), instructorDetail.getFacebook(), instructorDetail.getGithub(), instructorDetail.getHobby());
    }
}
