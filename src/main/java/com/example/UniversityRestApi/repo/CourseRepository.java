package com.example.UniversityRestApi.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UniversityRestApi.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByCourseName(String courseName);

}
