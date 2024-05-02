package com.example.UniversityRestApi.dto;

import java.util.List;

import com.example.UniversityRestApi.entity.Course;

public record StudentDTO(String firstName , String lastName , String email , String phoneNumber , String linkedin , String facebook , String github ,  List<Course> courses) {

}
