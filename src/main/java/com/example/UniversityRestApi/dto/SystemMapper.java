package com.example.UniversityRestApi.dto;

import com.example.UniversityRestApi.dto.creation.CourseCreationDTO;
import com.example.UniversityRestApi.dto.creation.InstructorCreationDTO;
import com.example.UniversityRestApi.dto.creation.StudentCreationDTO;
import com.example.UniversityRestApi.entity.Course;
import com.example.UniversityRestApi.entity.Instructor;
import com.example.UniversityRestApi.entity.Review;
import com.example.UniversityRestApi.entity.Student;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SystemMapper {

    CourseDTO courseToCourseDto(Course theCourse);

    Course courseCreationToCourse(CourseCreationDTO courseCreationDto);

    InstructorDTO instructorToInstructorDto(Instructor theInstructor);

    Instructor instructorCreationToInstructor(InstructorCreationDTO instructorCreationDto);
        
    StudentDTO studentToStudentDto(Student theStudent);
    
    Student studentCreationToStudent(StudentCreationDTO studentCreationDto);
    
    ReviewDTO toReviewDto(Review theReview);
    
    Review toReview(ReviewDTO reviewDto);
    
}
