package com.cg.ofr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userDetails")
public class User {

	@Id
	@NotNull(message = "User id Shouldn't be null or Blank !!")
	private int userId;
	@NotEmpty(message = "Username Shouldn't be null or Blank !!")
	@Size(min = 4, max = 12, message = "length of username should be min 4 and max 12 chars")
	private String userName;
	@NotEmpty(message = "password Shouldn't be null or Blank !!")
	@Size(min = 4, max = 15, message = "length of password should be min 4 and max 15 chars")
	private String password;
	@NotEmpty(message = "User type Shouldn't be null or Blank !!")
	private String userType;


}
