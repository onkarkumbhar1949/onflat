package com.cg.ofr.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlatBooking  {
	

	@Id
	@NotNull(message = "Booking number Shouldn't be null or Blank !!")
	private int bookingNo;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Tenant")
	private Tenant tenant;

	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Flat")
	private Flat flat;

	@NotNull(message = "Booking from date Shouldn't be null or Blank !!")
	private LocalDate bookingFromDate;

	@NotNull(message = "Booking to date Shouldn't be null or Blank !!")
	private LocalDate bookingToDate;


}