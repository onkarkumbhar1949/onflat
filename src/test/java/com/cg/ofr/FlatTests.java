package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.service.FlatService;

/*
 
 *Description      It is a FlatBooking Testcases implementation class that tests the
 *                 crud Operations defined in service interface
*/

@SpringBootTest
public class FlatTests extends OnlineFlatRentalApplicationTests {

	@Autowired
	private FlatService flatService;

	Flat flat1 = new Flat(199, 8888,
			new FlatAddress(1000, "gandhi-nagar", "Srikakulam", "Andhra Pradesh", 532284, "India"), "Yes");
	Flat flat2 = new Flat(299, 7777,
			new FlatAddress(1020, "gandhi-nagar", "Srikakulam", "Andhra Pradesh", 532284, "India"), "Yes");
	Flat flat3 = new Flat(399, 6666,
			new FlatAddress(1030, "gandhi-nagar", "Srikakulam", "Andhra Pradesh", 532284, "India"), "Yes");


	/*
	 * Method: updateFlatTest Description: To test the updateFlat Method of
	 * FlatService class
	 */

	@Test
	public void updateFlatTest() throws FlatNotFoundException {
		flatService.addFlat(flat1);
		Flat newFlat = new Flat(199, 8888,
				new FlatAddress(100, "gandhi-nagar", "Srikakulam", "Andhra Pradesh", 532284, "India"), "No");
		Flat updatesFlat = flatService.updateFlat(newFlat);
		assertEquals(updatesFlat.getAvailibilty(), newFlat.getAvailibilty());
		flatService.deleteFlat(flat1);
	}

}