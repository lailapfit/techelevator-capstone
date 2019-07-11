package com.techelevator.naturalpark;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Survey {
	@NotBlank(message="Please pick a park!")
	private String parkCode;
	
	@NotBlank(message="Please enter an email address")
	@Email(message="Please enter a valid email address")
	private String email;
	
	@NotBlank(message="Please enter valid state")
	private String state;
	@NotBlank(message="Please select your activity level")
	private String activityLevel;

	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	
}
