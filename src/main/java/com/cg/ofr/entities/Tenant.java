package com.cg.ofr.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tenant  {

	
	@Id
	@NotNull(message = "tanant id Shouldn't be null or Blank !!")
	private int tenantId;
	@NotNull(message = "Age Shouldn't be null or Blank or zero !!")
	private int age;

	@Embedded
	@NotNull(message = "flat address Shouldn't be null or Blank !!")
	private FlatAddress tAddress;


}