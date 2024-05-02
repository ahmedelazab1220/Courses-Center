package com.example.UniversityRestApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "courseName")
	@NotNull(message = "Course Name Is Required")
	private String courseName;

	@Column(name = "price")
	@NotNull(message = "Price Course Is Required")
	private int price;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	@JsonIgnore
	private List<Review> reviews;

	@Column(name = "publicationDate")
	@NotNull(message = "Publication Date Is Required")
	private LocalDate publicationDate;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	@JsonBackReference
	private Instructor theInstructor;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "courses")
	@JsonIgnore
	private List<Student> students;

	public Course(int id, @NotNull(message = "Course Name Is Required") String courseName,
			@NotNull(message = "Price Course Is Required") int price, List<Review> reviews,
			@NotNull(message = "Publication Date Is Required") LocalDate publicationDate, Instructor theInstructor,
			List<Student> students) {
		this.id = id;
		this.courseName = courseName;
		this.price = price;
		this.reviews = reviews;
		this.publicationDate = publicationDate;
		this.theInstructor = theInstructor;
		this.students = students;
	}

	public Course() {

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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", price=" + price + ", reviews=" + reviews
				+ ", publicationDate=" + publicationDate + ", theInstructor=" + theInstructor + ", students=" + students
				+ "]";
	}

}
