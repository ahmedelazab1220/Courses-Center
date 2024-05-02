package com.example.UniversityRestApi.dto;

import java.util.List;

import com.example.UniversityRestApi.entity.Course;

public record InstructorDTO(String firstName , String lastName , String email , String phoneNumber , String linkedin , String facebook , String github , String youtubeChannel , String hobby , List<Course> courses) {


}