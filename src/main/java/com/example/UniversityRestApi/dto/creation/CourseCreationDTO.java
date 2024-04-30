package com.example.UniversityRestApi.dto.creation;

import java.time.LocalDate;

public record CourseCreationDTO(String courseName , int price , LocalDate publicationDate) {

}
