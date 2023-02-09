package com.cg.ofr.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flat  {

	
	@Id
	@NotNull(message = "flat Id shouldn't be Empty or null !!")
	private int flatId;
	@NotNull(message = "cost shouldn't be null or zero ")
	private float cost;

	@Embedded
	@NotNull(message = "Flat address shouldn't be null or blank !!")
	private FlatAddress flatAddress;

	@NotEmpty(message = "Availability should be Yes or No ")
	private String availibilty;



}