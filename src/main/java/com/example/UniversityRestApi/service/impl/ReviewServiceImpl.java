package com.example.UniversityRestApi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UniversityRestApi.entity.Course;
import com.example.UniversityRestApi.entity.Review;
import com.example.UniversityRestApi.exc.CourseNotFoundException;
import com.example.UniversityRestApi.exc.ReviewNotFoundException;
import com.example.UniversityRestApi.repo.CourseRepository;
import com.example.UniversityRestApi.repo.ReviewRepository;
import com.example.UniversityRestApi.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Review findById(int theId) {
		Optional<Review> result = reviewRepository.findById(theId);

		if (result.isEmpty()) {
			throw new ReviewNotFoundException("Review Not Found!");
		}

		return reviewRepository.findById(theId).get();
	}

	@Override
	public void save(int theId, Review theReview) {

		Optional<Course> result = courseRepository.findById(theId);

		if (result.isEmpty()) {
			throw new CourseNotFoundException("Course Not Found!");
		}

		List<Review> reviews = null;

		reviews = result.get().getReviews();

		reviews.add(theReview);

		result.get().setReviews(reviews);

		courseRepository.save(result.get());
	}

	@Override
	public void deleteById(int theId) {
		Optional<Review> result = reviewRepository.findById(theId);

		if (result.isEmpty()) {
			throw new ReviewNotFoundException("Review Not Found!");
		}

		reviewRepository.deleteById(theId);
	}

	@Override
	public Review update(int theId, Review theReview) {
		Optional<Review> result = reviewRepository.findById(theId);

		if (result.isEmpty()) {
			throw new ReviewNotFoundException("Review Not Found!");
		}

		result.get().setComment(theReview.getComment());

		return reviewRepository.save(result.get());
	}

}
