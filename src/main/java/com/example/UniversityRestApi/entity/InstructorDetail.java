package com.example.UniversityRestApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="account_linkedin")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?linkedin\\.com\\/(?:in|pub)\\/[a-zA-Z0-9-]+" , 
             message="LinkedIn Link Not Valid")
	private String linkedin;
	
	@Column(name="account_facebook")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?facebook\\.com\\/(?:profile\\.php\\?id=)?(?:[a-zA-Z0-9.-]+)" ,
	         message = "FaceBook Link Not Valid")
	private String facebook;
	
	@Column(name="account_github")
	@Pattern(regexp = "https?:\\/\\/(?:www\\.)?github\\.com\\/[a-zA-Z0-9-]+" ,
             message = "Github Link Not Valid")
	private String github;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail" , cascade= {CascadeType.DETACH , CascadeType.MERGE ,
	          CascadeType.PERSIST , CascadeType.REFRESH})
	@JsonBackReference
	private Instructor instructor;
	
	public InstructorDetail() {
	
	}

	public InstructorDetail(String youtubeChannel,
			@Pattern(regexp = "https?:\\/\\/(?:www\\.)?linkedin\\.com\\/(?:in|pub)\\/[a-zA-Z0-9-]+", message = "This Link Not Valid") String linkedin,
			@Pattern(regexp = "https?:\\/\\/(?:www\\.)?facebook\\.com\\/(?:profile\\.php\\?id=)?(?:[a-zA-Z0-9.-]+)", message = "This Link Not Valid") String facebook,
			@Pattern(regexp = "https?:\\/\\/(?:www\\.)?github\\.com\\/[a-zA-Z0-9-]+", message = "This Link Not Valid") String github,
			String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.linkedin = linkedin;
		this.facebook = facebook;
		this.github = github;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
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

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", linkedin=" + linkedin
				+ ", facebook=" + facebook + ", github=" + github + ", hobby=" + hobby + ", instructor=" + instructor
				+ "]";
	}
	
}
