package com.example.UniversityRestApi.dto.creation;

import java.time.LocalDate;

import com.example.UniversityRestApi.entity.Instructor;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public record CourseCreationDTO(String courseName , int price , LocalDate publicationDate , Instructor theInstructor) {

}
