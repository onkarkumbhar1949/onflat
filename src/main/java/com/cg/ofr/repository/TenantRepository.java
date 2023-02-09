package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Tenant;

/*
      It is a user repository interface that extends jpa repository 
                     that contains inbuilt methods for various operations
*/

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {

}