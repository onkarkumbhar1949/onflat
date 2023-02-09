package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Landlord;

/*  It is a landlord repository interface that extends jpa repository 
                     that contains inbuilt methods for various operations
                     */
@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Integer> {

}