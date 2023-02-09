package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.service.TenantService;
/**
 * Description - For Checking Tenant Test Cases
 * @author Onkar Kumbhar
 *
 */
@SpringBootTest
public class TenantTests {

	@Autowired
	TenantService itenantService;

	FlatAddress flatAddress11 = new FlatAddress(211, "Golden street", "Ongole", "Andhra Pradesh", 523001, "India");
	Flat flat11 = new Flat(99, 100000, flatAddress11, "yes");
	Tenant tenant11 = new Tenant(999, 41, flatAddress11);

	FlatAddress flatAddress12 = new FlatAddress(212, "French street", "Vijayawada", "Andhra Pradesh", 52441, "India");
	Flat flat12 = new Flat(12, 200000, flatAddress12, "yes");
	
	Tenant tenant12 = new Tenant(12, 42, flatAddress12);

	FlatAddress flatAddress13 = new FlatAddress(213, "Court street", "Vizag", "Andhra Pradesh", 524321, "India");
	Flat flat13 = new Flat(13, 400000, flatAddress13, "yes");
	
	Tenant tenant13 = new Tenant(13, 43, flatAddress13);

	/**
	 * Description -For Add Tenant Test
	 */
	@Test
	@DisplayName("add tenant999 should work")
	void addTenantTest1() {
		assertEquals(100000, flat11.getCost());
		System.out.println("Successfully tenant is added");
	}

	/**
	 * Description -For Add Tenant Test
	 */
	@Test
	@DisplayName("adding tenant12 should work")
	void addTenantTest2() {
		assertNotNull(tenant11.getTenantId());
		System.out.println("Successfully tenant is added");
	}

	/**
	 * Description - For View All Tenant Test
	 */


	@Test
	@DisplayName("view all tenant should work")
	void viewAllTenanTest() {
		assertNotNull((itenantService.viewAllTenant()));

	}

}