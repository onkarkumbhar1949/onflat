package com.cg.ofr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.service.FlatBookingService;

import io.swagger.annotations.Api;
/*
 * Description     It is a controller class that controls the
          		   data flow into model object and updates the view whenever data
           		   changes 
 * Author         Onkar Kumbhar
 */

@RestController
@Api(value = "Swagger2DemoRestController")
public class FlatBookingController {
	@Autowired
	private FlatBookingService flatBookingService;

	/*
	 * Description: It is used to add FlatBooking into Landlord_details table
	 * 
	 * @param FlatBooking: FlatBooking's reference variable.
	 * 
	 * @returns FlatBooking It returns FlatBooking with details
	 * 
	 * @PostMapping: It is used to handle POST type of request method
	 * 
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 */
	@PostMapping("/flatbooking")
	public FlatBooking addFlatBooking(@Valid @RequestBody FlatBooking flatBooking) {
		return flatBookingService.addFlatBooking(flatBooking);
	}

	/*
	 * Method: updateFlatBooking Description: It is used to update FlatBooking
	 * details into FlatBooking_details table.
	 * 
	 * @param FlatBooking: FlatBooking reference variable.
	 * 
	 * @returns FlatBooking It returns updated details of the existed FlatBooking.
	 * 
	 * @PutMapping: It is used to handle PUT type of request method
	 * 
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 */
	@PutMapping("/flatbooking")
	public FlatBooking updateFlatBooking(@Valid @RequestBody FlatBooking flatBooking) {
		return flatBookingService.updateFlatBooking(flatBooking);
	}

	/*
	 * Method: removeFlatBooking Description: It is used to remove user
	 * 
	 * @param FlatBooking: FlatBooking reference variable.
	 * 
	 * @returns FlatBooking It returns the FlatBooking that has been deleted
	 * 
	 * @DeleteMapping: It is used to handle DELETE type of request method.
	 * 
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 */

	@DeleteMapping("/flatbooking/{id}")
	public FlatBooking deleteFlatBookingById(@PathVariable int id) {
		return flatBookingService.deleteFlatBooking(id);
	}

	/*
	 * Method: viewFlatBooking Description: To display the FlatBooking by Id
	 * (Primary key)
	 * 
	 * @param id: id of the FlatBooking.
	 * 
	 * @returns FlatBooking If FlatBooking with Id presents it returns FlatBooking
	 * else throws FlatBookingNotFoundException
	 * 
	 * @throws FlatBookingNotFoundException It is raised due to invalid LandlordId
	 * 
	 * @GetMapping: It is used to handle GET type of request method.
	 * 
	 * @PathVariable: It is used for data passed in the URI and transfer its values
	 * to parameter variables.
	 */
	@GetMapping("/flatbooking/{id}")
	public FlatBooking viewFlatBooking(@PathVariable Integer id) throws FlatBookingNotFoundException {
		return flatBookingService.viewFlatBooking(id);
	}

	/*
	 * Method: viewAllFlatBookings Description: To display all the users
	 * 
	 * @returns List<FlatBookings > It returns all the FlatBookings present in
	 * database
	 * 
	 * @GetMapping: It is used to handle GET type of request method
	 */
	@GetMapping("/flatbookings")
	public List<FlatBooking> viewAllFlatBooking() {
		return flatBookingService.viewAllFlatBooking();
	}

}