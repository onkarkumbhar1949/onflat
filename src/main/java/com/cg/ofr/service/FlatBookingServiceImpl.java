package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.repository.FlatBookingRepository;
import com.cg.ofr.repository.TenantRepository;

/*      It is a FlatBooking service implementation class that defines the methods
 *                           mentioned in its interface.
 */
@Service
@Transactional
public class FlatBookingServiceImpl implements FlatBookingService {

	@Autowired
	private FlatBookingRepository flatBookingRepository;
	@Autowired
	private TenantRepository tenantRepository;

	/*
	 * Method: addFlatBooking Description: It is used to add FlatBooking into
	 * FlatBooking_details table
	 */
	@Override
	public FlatBooking addFlatBooking(FlatBooking flatBooking) {
		try {
			int checkAge = flatBooking.getTenant().getAge();
			if (checkAge > 0) {
				flatBooking.getFlat().setAvailibilty("No");
				return flatBookingRepository.save(flatBooking);
			}
		} catch (Exception e) {
			throw new EntityCreationException(e.getMessage());
		}
		return flatBooking;
	}

	/*
	 * It is used to update FlatBooking details into FlatBooking_details table.
	 */
	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatbooking) {
		try {
			Optional<FlatBooking> flatBooking1 = flatBookingRepository.findById(flatbooking.getBookingNo());
			if (flatBooking1.isPresent()) {
				return flatBookingRepository.save(flatbooking);
			} else {
				throw new EntityUpdationException(
						"Cannot Update FlatBooking with bookingNo" + flatbooking.getBookingNo());
			}
		} catch (Exception e) {
			throw new EntityUpdationException(e.getMessage());
		}
	}

	/*
	 * It is used to remove FlatBooking
	 */
	@Override
	public FlatBooking deleteFlatBooking(int flatBooking) {
		try {
			
			FlatBooking flatBooking2 = flatBookingRepository.findById(flatBooking).get();
			Tenant tenant = flatBooking2.getTenant();
			if (flatBooking2!=null) {
				flatBooking2.getFlat().setAvailibilty("Yes");
				tenantRepository.delete(tenant);
				flatBookingRepository.delete(flatBooking2);
				return flatBooking2;
			} else {
				throw new EntityDeletionException("Cannot Delete flatbooking as the FlatBooking with"
						+ flatBooking+ "does not exist");
			}
		} catch (Exception e) {
			throw new EntityDeletionException(e.getMessage());
		}
	}

	/*
	 * To display the FlatBooking by Id (Primary key)
	 * 
	 * @param id: id of the FlatBooking.
	 * 
	 * @throws FlatbookingNotFoundException
	 * 
	 * @returns User If user with Id presents it returns user else throws
	 * FlatbookingNotFoundException
	 * 
	 * @throws FlatbookingNotFoundException It is raised due to invalid
	 * FlatbookingId
	 * 
	 */
	@Override
	public FlatBooking viewFlatBooking(Integer id) throws FlatBookingNotFoundException {
		try {
			Optional<FlatBooking> flatBooking = flatBookingRepository.findById(id);
			if (flatBooking.isPresent()) {
				return flatBooking.get();
			} else {
				throw new FlatBookingNotFoundException("the FlatBooking with id " + id + " is not found");
			}
		} catch (Exception e) {
			throw new FlatBookingNotFoundException(e.getMessage());
		}
	}

	/*
	 * To display all the FlatBookings
	 * 
	 * @throws EmptyEntityListException
	 * 
	 * @returns List<FlatBookings> It returns all the FlatBookings present in
	 * database
	 * 
	 */
	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> flatbookings = new ArrayList<>();
		try {
			flatbookings = flatBookingRepository.findAll();
			if (flatbookings.isEmpty()) {
				throw new EmptyEntityListException("No FlatBooking Found");
			} else
				return flatbookings;
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}

	}

}