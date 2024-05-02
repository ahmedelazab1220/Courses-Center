package com.example.UniversityRestApi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	@NotNull(message = "First Name Is Required")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", unique = true)
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9._]{0,24}@gmail\\.com$", message = "use characters from a to z , A to Z , numbers from 0 to 9 , and special characters (. , _) only allowed")
	@NotNull(message = "Email Is Required")
	private String email;

	@Column(name = "phoneNumber")
	@Pattern(regexp = "^01[012][0-9]{8}$", message = "use an egyptian number to log in")
	@NotNull(message = "PhoneNumber Is Required")
	private String phoneNumber;

	@Column(name = "account_linkedin")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?linkedin\\.com\\/(?:in|pub)\\/[a-zA-Z0-9-]+", message = "LinkedIn Link Not Valid")
	private String linkedin;

	@Column(name = "account_facebook")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?facebook\\.com\\/(?:profile\\.php\\?id=)?(?:[a-zA-Z0-9.-]+)", message = "FaceBook Link Not Valid")
	private String facebook;

	@Column(name = "account_github")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?github\\.com\\/[a-zA-Z0-9-]+", message = "Github Link Not Valid")
	private String github;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	public Student() {

	}

	public Student(int id, @NotNull(message = "First Name Is Required") String firstName, String lastName,
			@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9._]{0,24}@gmail\\.com$", message = "use characters from a to z , A to Z , numbers from 0 to 9 , and special characters (. , _) only allowed") @NotNull(message = "Email Is Required") String email,
			@Pattern(regexp = "^01[012][0-9]{8}$", message = "use an egyptian number to log in") @NotNull(message = "PhoneNumber Is Required") String phoneNumber,
			@Pattern(regexp = "https?:\\/\\/(?:www\\.)?linkedin\\.com\\/(?:in|pub)\\/[a-zA-Z0-9-]+", message = "LinkedIn Link Not Valid") String linkedin,
			@Pattern(regexp = "https?:\\/\\/(?:www\\.)?facebook\\.com\\/(?:profile\\.php\\?id=)?(?:[a-zA-Z0-9.-]+)", message = "FaceBook Link Not Valid") String facebook,
			@Pattern(regexp = "https?:\\/\\/(?:www\\.)?github\\.com\\/[a-zA-Z0-9-]+", message = "Github Link Not Valid") String github,
			List<Course> courses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.linkedin = linkedin;
		this.facebook = facebook;
		this.github = github;
		this.courses = courses;
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

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
