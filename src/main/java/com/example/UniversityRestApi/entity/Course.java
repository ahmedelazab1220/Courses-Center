package com.example.UniversityRestApi.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="courseName")
	@NotNull(message = "Course Name Is Required")
	private String courseName;
	
	@Column(name="price")
	@NotNull(message = "Price Course Is Required")
	private int price;
	
	@Column(name="publicationDate")
	@NotNull(message = "Publication Date Is Required")
	private LocalDate publicationDate;
	
	@ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	@JsonBackReference
	private Instructor theInstructor;
	
	public Course() {
		
	}

	public Course(String courseName, int price, LocalDate publicationDate) {
		this.courseName = courseName;
		this.price = price;
		this.publicationDate = publicationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Instructor getTheInstructor() {
		return theInstructor;
	}

	public void setTheInstructor(Instructor theInstructor) {
		this.theInstructor = theInstructor;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", price=" + price + ", publicationDate=" + publicationDate + "]";
	}
	
}
