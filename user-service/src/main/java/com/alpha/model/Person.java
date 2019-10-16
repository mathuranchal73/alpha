package com.alpha.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.alpha.model.audit.PersonDateAudit;
import com.alpha.model.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created Date: 15 October 2019
 * @author Anchal.Mathur
 *
 */

@Entity
@Table(name="Person", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "mobileNo"
            }),
            @UniqueConstraint(columnNames = {
                "email"
            })
    })
@SequenceGenerator(name="seq", initialValue=000000, allocationSize=100)
@ApiModel
public class Person extends UserDateAudit implements Serializable {
	

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
	 private String email;
	 
	 @Size(max = 10)
	 @ApiModelProperty(notes = "Date of Birth of the User", required = false)
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
	 
	 @JsonIgnore
	 private Instant emailInsertedOn;
	 
	 @JsonIgnore
	 private Instant emailValidatedOn;
	 
	 @ApiModelProperty(notes = "The image URL of the product", required = false)
	 private String profilePicture;
	 
	 @ApiModelProperty(notes = "Application Specific UUID of User", required = true)
	 private String user_uuid;
	 
	 

	public Person(@NotBlank @Size(max = 40) String firstName, @NotBlank @Size(max = 40) String lastName,
			String country_cd, String source_cd, String user_uuid) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country_cd = country_cd;
		this.source_cd = source_cd;
		this.user_uuid = user_uuid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}
	 
	 
	 
	 
	 

	 
}
