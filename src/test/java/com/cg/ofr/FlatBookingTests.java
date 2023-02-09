package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.service.FlatBookingService;

@SpringBootTest
public class FlatBookingTests extends OnlineFlatRentalApplicationTests {

	@Autowired
	private FlatBookingService flatBookingService;

	@Test
	public void updateFlatBookingTest1() {
		FlatAddress flatAddress3 = new FlatAddress(1080, "8", "Vizag", "AndhraPradesh", 530018, "India");
		Flat flat3 = new Flat(1005, 1200000, flatAddress3, "yes");
		Tenant tenant3 = new Tenant(301, 30, flatAddress3);
		FlatBooking flatBooking3 = new FlatBooking(153, tenant3, flat3, LocalDate.of(2020, 11, 21),
				LocalDate.of(2025, 06, 26));

		flatBooking3.setBookingToDate(LocalDate.of(2020, 5, 9));
		assertEquals(flatBooking3.getBookingToDate(), LocalDate.of(2020, 5, 9));
	}

//	@Test
//	public void viewAllFlatBookingTest1() {
//		assertNotNull(flatBookingService.viewAllFlatBooking());
//	}
//
//	@Test
//	public void viewAllFlatBookingTest2() {
//		assertNotNull(flatBookingService.viewAllFlatBooking());
//	}
}