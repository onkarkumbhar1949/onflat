package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

public interface FlatBookingService {

	public FlatBooking addFlatBooking(FlatBooking flatbooking);

	public FlatBooking updateFlatBooking(FlatBooking flatbooking);

	public FlatBooking deleteFlatBooking(int flatbooking);

	public FlatBooking viewFlatBooking(Integer id) throws FlatBookingNotFoundException;

	public List<FlatBooking> viewAllFlatBooking();

}
