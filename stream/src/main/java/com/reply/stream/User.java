package com.reply.stream;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	@NotNull(message="username cannot be empty")
	@Size(min=5,max=20, message="Password must be equal to or greater than 5 characters and less than 20 characters ")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String userName;
	
	@NotNull(message="password cannot be empty")
	@Size(min=8,  message="Password must be equal to or greater than 8 characters")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Pattern(regexp = "(?=(.*[0-9]))(?=.*[a-z])(?=(.*[A-Z]))(?=(.*)).{8,}")
	private String password;
	
	@NotNull(message="email id cannot be empty")
	@Email(message = "please enter valid Email id")
	private String email;
	
	@NotNull(message="date of birth cannot be empty")
	@Past(message="date of birth has to be in past")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	//@Adult(message = "user should be at least 18 years old")
	private LocalDate birthDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Size(min =16, max=16, message="credit card should be of 16 digts")
	private String creditCardNo;
	
	//@Digits(integer=16, fraction=0)
    //private BigDecimal creditCardNo;
	
	public User() {
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getCreditCardNo() {
		return creditCardNo;
	}
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
}
