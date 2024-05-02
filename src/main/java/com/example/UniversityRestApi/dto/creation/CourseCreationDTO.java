package com.example.UniversityRestApi.dto.creation;

import java.time.LocalDate;

import com.example.UniversityRestApi.entity.Instructor;

public record CourseCreationDTO(String courseName, int price, LocalDate publicationDate, Instructor theInstructor) {

}
