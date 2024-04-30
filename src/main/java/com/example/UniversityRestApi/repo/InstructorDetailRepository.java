package com.example.UniversityRestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UniversityRestApi.entity.InstructorDetail;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {

}
