package com.example.UniversityRestApi.dto.response;

import com.example.UniversityRestApi.entity.InstructorDetail;

public record InstructorCourse(String firstName , String lastName , String email , String phoneNumber , InstructorDetail instructorDetail) {

}
