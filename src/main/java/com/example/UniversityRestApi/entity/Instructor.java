package com.example.UniversityRestApi.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;


@Entity
@Table(name = "instructor")
public class Instructor {

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
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9._]{0,24}@gmail\\.com$",
			message = "use characters from a to z , A to Z , numbers from 0 to 9 , and special characters (. , _) only allowed")
	@NotNull(message = "Email Is Required")
	private String email;

	@Column(name = "phoneNumber")
	@Pattern(regexp = "^01[012][0-9]{8}$",
			message = "use an egyptian number to log in")
	@NotNull(message = "PhoneNumber Is Required")
	private String phoneNumber;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "account_linkedin")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?linkedin\\.com\\/(?:in|pub)\\/[a-zA-Z0-9-]+",
			message = "LinkedIn Link Not Valid")
	private String linkedin;

	@Column(name = "account_facebook")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?facebook\\.com\\/(?:profile\\.php\\?id=)?(?:[a-zA-Z0-9.-]+)",
			message = "FaceBook Link Not Valid")
	private String facebook;

	@Column(name = "account_github")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?github\\.com\\/[a-zA-Z0-9-]+",
			message = "Github Link Not Valid")
	private String github;

	@Column(name = "hobby")
	private String hobby;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "theInstructor")
	@JsonManagedReference
	private List<Course> courses;

	public Instructor(int id, String firstName, String lastName, @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9._]{0,24}@gmail\\.com$",
			message = "use characters from a to z , A to Z , numbers from 0 to 9 , and special characters (. , _) only allowed") @NotNull(message = "Email Is Required") String email, @Pattern(regexp = "^01[012][0-9]{8}$",
			message = "use an egyptian number to log in") @NotNull(message = "PhoneNumber Is Required") String phoneNumber, String youtubeChannel, @Pattern(regexp = "https?:\\/\\/(?:www\\.)?linkedin\\.com\\/(?:in|pub)\\/[a-zA-Z0-9-]+",
			message = "LinkedIn Link Not Valid") String linkedin, @Pattern(regexp = "https?:\\/\\/(?:www\\.)?facebook\\.com\\/(?:profile\\.php\\?id=)?(?:[a-zA-Z0-9.-]+)",
			message = "FaceBook Link Not Valid") String facebook, @Pattern(regexp = "https?:\\/\\/(?:www\\.)?github\\.com\\/[a-zA-Z0-9-]+",
			message = "Github Link Not Valid") String github, String hobby, List<Course> courses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.youtubeChannel = youtubeChannel;
		this.linkedin = linkedin;
		this.facebook = facebook;
		this.github = github;
		this.hobby = hobby;
		this.courses = courses;
	}

	public Instructor() {
		
	}

	public String toString() {
		return "Instructor(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", phoneNumber=" + this.getPhoneNumber() + ", youtubeChannel=" + this.getYoutubeChannel() + ", linkedin=" + this.getLinkedin() + ", facebook=" + this.getFacebook() + ", github=" + this.getGithub() + ", hobby=" + this.getHobby() + ", courses=" + this.getCourses() + ")";
	}

	public int getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9._]{0,24}@gmail\\.com$",
			message = "use characters from a to z , A to Z , numbers from 0 to 9 , and special characters (. , _) only allowed") @NotNull(message = "Email Is Required") String getEmail() {
		return this.email;
	}

	public @Pattern(regexp = "^01[012][0-9]{8}$",
			message = "use an egyptian number to log in") @NotNull(message = "PhoneNumber Is Required") String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getYoutubeChannel() {
		return this.youtubeChannel;
	}

	public @Pattern(regexp = "https?:\\/\\/(?:www\\.)?linkedin\\.com\\/(?:in|pub)\\/[a-zA-Z0-9-]+",
			message = "LinkedIn Link Not Valid") String getLinkedin() {
		return this.linkedin;
	}

	public @Pattern(regexp = "https?:\\/\\/(?:www\\.)?facebook\\.com\\/(?:profile\\.php\\?id=)?(?:[a-zA-Z0-9.-]+)",
			message = "FaceBook Link Not Valid") String getFacebook() {
		return this.facebook;
	}

	public @Pattern(regexp = "https?:\\/\\/(?:www\\.)?github\\.com\\/[a-zA-Z0-9-]+",
			message = "Github Link Not Valid") String getGithub() {
		return this.github;
	}

	public String getHobby() {
		return this.hobby;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9._]{0,24}@gmail\\.com$",
			message = "use characters from a to z , A to Z , numbers from 0 to 9 , and special characters (. , _) only allowed") @NotNull(message = "Email Is Required") String email) {
		this.email = email;
	}

	public void setPhoneNumber(@Pattern(regexp = "^01[012][0-9]{8}$",
			message = "use an egyptian number to log in") @NotNull(message = "PhoneNumber Is Required") String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public void setLinkedin(@Pattern(regexp = "https?:\\/\\/(?:www\\.)?linkedin\\.com\\/(?:in|pub)\\/[a-zA-Z0-9-]+",
			message = "LinkedIn Link Not Valid") String linkedin) {
		this.linkedin = linkedin;
	}

	public void setFacebook(@Pattern(regexp = "https?:\\/\\/(?:www\\.)?facebook\\.com\\/(?:profile\\.php\\?id=)?(?:[a-zA-Z0-9.-]+)",
			message = "FaceBook Link Not Valid") String facebook) {
		this.facebook = facebook;
	}

	public void setGithub(@Pattern(regexp = "https?:\\/\\/(?:www\\.)?github\\.com\\/[a-zA-Z0-9-]+",
			message = "Github Link Not Valid") String github) {
		this.github = github;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
