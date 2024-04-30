package com.example.UniversityRestApi.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name="instructor")
public class Instructor {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email" , unique=true)
	@Pattern(regexp="^[a-zA-Z][a-zA-Z0-9._]{0,24}@gmail\\.com$" , 
	message="use characters from a to z , A to Z , numbers from 0 to 9 , and special characters (. , _) only allowed")
	@NotNull(message = "Email Is Required")
	private String email;
	
	@Column(name="phoneNumber")
	@Pattern(regexp="^01[012][0-9]{8}$" , 
	message="use an egyptian number to log in")
	@NotNull(message = "PhoneNumber Is Required")
	private String phoneNumber;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	@JsonManagedReference
	private InstructorDetail instructorDetail;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "theInstructor")
	@JsonManagedReference
	private List<Course> courses;
	
	public Instructor() {

	}

	public Instructor(String firstName, String lastName,
			@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9._]{0,24}@gmail\\.com$", message = "use characters from a to z , A to Z , numbers from 0 to 9 , and special characters (. , _) only allowed") @NotNull(message = "Email Is Required") String email,
			@Pattern(regexp = "^01[012][0-9]{8}$", message = "use an egyptian number to log in") @NotNull(message = "PhoneNumber Is Required") String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		System.out.println(instructorDetail.toString());
		this.instructorDetail = instructorDetail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
}
