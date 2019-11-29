package com.alpha.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.alpha.model.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Student", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "mobileNo"
            }),
            @UniqueConstraint(columnNames = {
                "studentEmail"
            })
    })
@SequenceGenerator(name="seq", initialValue=000000, allocationSize=100000)
@ApiModel
public class Student extends UserDateAudit implements Serializable {
	
	 private static final long serialVersionUID = 1L;

	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	 @Id 
	 @ApiModelProperty(notes = "The database generated user ID")
	 private long id;
	 
	 @NotBlank
	 @Size(max = 40)
	 @ApiModelProperty(notes = "First Name of the User", required = true)
	 private String firstName;
	 
	 @NotBlank
	 @Size(max = 40)
	 @ApiModelProperty(notes = "Last Name of the User", required = true)
	 private String lastName;
	 
	 @NaturalId
	 @Size(max = 40)
	 @Email
	 @ApiModelProperty(notes = "Email ID of the User", required = true)
	 private String studentEmail;
	 
	 @NaturalId
	 @Size(max = 40)
	 @Email
	 @ApiModelProperty(notes = "Email ID of Parent", required = true)
	 private String parentEmail;
	 
	 @ApiModelProperty(notes = "Date Of Admission of Student", required = false)
	 private String doa;
	 
	 @ApiModelProperty(notes = "System generated Registration No.", required = false)
	 private String registrationNo;
	 
	 @ApiModelProperty(notes = "System generated Roll No.", required = false)
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	 private String rollNo;
	 
	 @ApiModelProperty(notes = "Academic Session to which Student Registered", required = false)
	 private String academicSessions;
	 
	 @Size(max = 10)
	 @ApiModelProperty(notes = "Date of Birth of the Student", required = false)
	 private String birthdate;
	 
	 @Size(max = 10)
	 @ApiModelProperty(notes = "10 Digit Unique Mobile No. of the User", required = false)
	 private String mobileNo;
	 
	 @ApiModelProperty(notes = "Gender of the User", required = false)
	 private String gender;
	
	 @ApiModelProperty(notes = "Code of Country of Residence of the User", required = true)
	 private String country_cd;
	 
	 @ApiModelProperty(notes = "Application Specific Code of Referring Source", required = true)
	 private String source_cd;
	 
	 private boolean enabled;
	 
	 public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@JsonIgnore
	 private Instant emailInsertedOn;
	 
	 @JsonIgnore
	 private Instant emailValidatedOn;
	 
	 @ApiModelProperty(notes = "The image URL of the product", required = false)
	 private String profilePicture;
	 
	 @NotNull
	 @ApiModelProperty(notes = "Application Specific UUID of Student", required = true)
	 private String uuid;

	 public Student() {
			
		}
	 
	 public Student(String firstName, String lastName, String doa, 
				String academicSessions,@Size(max = 40) @Email String studentEmail,
				@NotBlank @Size(max = 40) @Email String parentEmail, @NotBlank @Size(max = 100) String uuid, Boolean enabled) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.doa = doa;
			this.academicSessions = academicSessions;
			this.studentEmail = studentEmail;
			this.parentEmail = parentEmail;
			this.uuid = uuid;
			this.enabled=enabled;
		}

		
		public Student(String firstName, String lastName, String registrationNo,
				@Size(max = 40) @Email String studentEmail, @NotBlank @Size(max = 40) @Email String parentEmail) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.registrationNo = registrationNo;
			this.studentEmail = studentEmail;
			this.parentEmail = parentEmail;
		}

	 
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public String getDoa() {
		return doa;
	}

	public void setDoa(String doa) {
		this.doa = doa;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getAcademicSessions() {
		return academicSessions;
	}

	public void setAcademicSessions(String academicSessions) {
		this.academicSessions = academicSessions;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry_cd() {
		return country_cd;
	}

	public void setCountry_cd(String country_cd) {
		this.country_cd = country_cd;
	}

	public String getSource_cd() {
		return source_cd;
	}

	public void setSource_cd(String source_cd) {
		this.source_cd = source_cd;
	}

	public Instant getEmailInsertedOn() {
		return emailInsertedOn;
	}

	public void setEmailInsertedOn(Instant emailInsertedOn) {
		this.emailInsertedOn = emailInsertedOn;
	}

	public Instant getEmailValidatedOn() {
		return emailValidatedOn;
	}

	public void setEmailValidatedOn(Instant emailValidatedOn) {
		this.emailValidatedOn = emailValidatedOn;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	 
	
	

}
