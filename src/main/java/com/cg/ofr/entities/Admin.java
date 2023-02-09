package com.cg.ofr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Admin {
	@Id
	@NotNull(message = "Admin Id shouldn't be Balank or null !!")
	@Size(min = 1, max = 4, message = "Admin Id Length should be min 1 and max 4 digits")
	private int adminId;

	@NotEmpty(message = "Admin Password shouldn't be null or blank !!")
	@Size(min = 4, max = 9, message = "Admin password should be min 4 and max 9 chars !!")
	private String adminPassword;


}
