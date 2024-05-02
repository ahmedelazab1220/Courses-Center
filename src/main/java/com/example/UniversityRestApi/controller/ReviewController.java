package com.example.UniversityRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UniversityRestApi.dto.ReviewDTO;
import com.example.UniversityRestApi.dto.SystemMapper;
import com.example.UniversityRestApi.service.impl.ReviewServiceImpl;

@RestController
@RequestMapping("api/v4/reviews")
public class ReviewController {

	@Autowired 
	private ReviewServiceImpl reviewService;
	
	@Autowired
	private SystemMapper mapper;
	
	@PostMapping("/{courseId}")
	public ResponseEntity<?> addReview(@PathVariable("courseId") int courseId , @RequestBody ReviewDTO reviewDto){
		reviewService.save(courseId , mapper.toReview(reviewDto));
		
		return new ResponseEntity<>("Review Added" , HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{reviewId}")
	public ResponseEntity<ReviewDTO> updateReview(@PathVariable("reviewId") int reviewId ,  @RequestBody ReviewDTO reviewDto){
		
		ReviewDTO review = mapper.toReviewDto(reviewService.update(reviewId, mapper.toReview(reviewDto)));
		
		return new ResponseEntity<>(review , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable("reviewId") int reviewId){
		
		reviewService.deleteById(reviewId);
		
		return new ResponseEntity<>("Success Delete Review" , HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDTO> getReview(@PathVariable("reviewId") int reviewId){
		
		ReviewDTO review = mapper.toReviewDto(reviewService.findById(reviewId));
		
		return new ResponseEntity<>(review , HttpStatus.ACCEPTED);
	}
	
}
