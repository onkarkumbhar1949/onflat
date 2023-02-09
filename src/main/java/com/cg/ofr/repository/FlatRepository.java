package com.cg.ofr.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.ofr.entities.Flat;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Integer> {

	/*
	 * Method: viewAllFlatByCostAndAvailability Description: It is used to find the
	 * flat based on cost and availability
	 */
	@Query("select f from Flat f where f.cost=?1 and f.availibilty = ?2")
	public List<Flat> viewAllFlatByCostAndAvailability(float cost, String availability);
}