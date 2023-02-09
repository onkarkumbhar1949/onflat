package com.cg.ofr.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlatAddress {

	@NotEmpty(message = "House number shouldn't be Empty or Null !!")
	private int houseNo;
	@NotEmpty(message = "Street Shouldn't be null or Blank !!")
	private String street;
	@NotEmpty(message = "city Shouldn't be null or Blank !!")
	private String city;
	@NotEmpty(message = "State Shouldn't be null or Blank !!")
	private String state;
	@NotEmpty(message = "pin Shouldn't be null or Blank !!")
	private int pin;
	@NotEmpty(message = "country Shouldn't be null or Blank !!")
	private String country;


}
