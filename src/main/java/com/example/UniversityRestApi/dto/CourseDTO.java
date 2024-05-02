package com.example.UniversityRestApi.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.UniversityRestApi.entity.Review;


public record CourseDTO(String courseName , int price , LocalDate publicationDate , List<Review> reviews){

}