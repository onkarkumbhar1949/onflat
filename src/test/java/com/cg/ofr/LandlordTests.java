package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.service.LandlordServiceImpl;

@SpringBootTest
public class LandlordTests extends OnlineFlatRentalApplicationTests {

	@Autowired
	private LandlordServiceImpl ilandlordserviceimpl;

	/**
	 * Description - For Update Landlord Test
	 */

	@Test
	public void updateLandlord1() {
		FlatAddress flataddress = new FlatAddress(114, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(1020, 5000, flataddress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(190, "anil", 25, flatlist);
		landlord.setLandlordName("suresh");
		ilandlordserviceimpl.updateLandlord(landlord);
		assertEquals("suresh", landlord.getLandlordName());

	}

	/**
	 * Description - For Update Landlord Test
	 */
	@Test
	public void updateLandlord2() {
		FlatAddress flatadress = new FlatAddress(115, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(1030, 5000, flatadress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(170, "sunil", 25, flatlist);
		landlord.setLandlordAge(40);
		ilandlordserviceimpl.updateLandlord(landlord);
		assertEquals(40, landlord.getLandlordAge());

	}


}