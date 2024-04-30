package com.example.UniversityRestApi.dto;

import java.time.LocalDate;

import com.example.UniversityRestApi.dto.response.InstructorCourse;


public record CourseDTO(String courseName , int price , LocalDate publicationDate , InstructorCourse theInstructor) {

}