package com.example.UniversityRestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UniversityRestApi.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
