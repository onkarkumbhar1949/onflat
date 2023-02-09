package com.cg.ofr.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Landlord {

	@Id
	@NotNull(message = "land lord id Shouldn't be null or Blank !!")
	private int landlordId;
	@NotEmpty(message = "land lord name Shouldn't be null or Blank !!")
	private String landlordName;
	@NotNull(message = "land lord age Shouldn't be null or Blank !!")
	private int landlordAge;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Flat> flatList;


}
