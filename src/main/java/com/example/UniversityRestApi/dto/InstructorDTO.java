package com.example.UniversityRestApi.dto;

import java.util.List;

import com.example.UniversityRestApi.entity.Course;
import com.example.UniversityRestApi.entity.InstructorDetail;

public record InstructorDTO(String firstName , String lastName , String email , String phoneNumber , InstructorDetail instructorDetail , List<Course> courses) {


}