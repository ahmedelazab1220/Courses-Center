package com.example.UniversityRestApi.service;

import com.example.UniversityRestApi.entity.Review;

public interface ReviewService {

	void save(int theId, Review theReview);

	void deleteById(int theId);

	Review update(int theId, Review theReview);

	Review findById(int theId);

}
