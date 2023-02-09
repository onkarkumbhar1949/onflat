package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.LandlordRepository;

/*
 * Description      It is a user service implementation class that defines the methods
                    mentioned in its interface.
 */

@Service
@Transactional
public class LandlordServiceImpl implements LandlordService {

	@Autowired
	private LandlordRepository landlordRepository;

	/*
	 * It is used to add landlord into landlord_details table
	 * 
	 * @param user: User's reference variable.
	 * 
	 * @returns User It returns user with details
	 */

	@Override
	public Landlord addLandlord(Landlord landlord) {
		try {
			return landlordRepository.save(landlord);
		} catch (Exception e) {
			throw new EntityCreationException("valid details of landlord is not entered");
		}

	}

	/*
	 * It is used to update landlord details into landlord_details table.
	 * 
	 * @param use Landlord's reference variable.
	 * 
	 * @returns User It returns updated details of the existed user.
	 */

	@Override
	public Landlord updateLandlord(Landlord landlord) {
		try {
			Optional<Landlord> updatelandlord = landlordRepository.findById(landlord.getLandlordId());
			if (updatelandlord.isPresent()) {
				return landlordRepository.save(landlord);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityUpdationException("No updation found");
		}

	}

	/*
	 * It is used to remove landlord
	 * 
	 * @param user: Landlord's reference variable.
	 * 
	 * @returns User It returns the landlord that has been deleted
	 * 
	 * @throws UserNotFoundException: It is raised due to invalid landlord.
	 */

	@Override
	public Landlord deleteLandlord(Landlord landlord) {
		try {

			Optional<Landlord> deletelandlord = landlordRepository.findById(landlord.getLandlordId());
			if (deletelandlord.isPresent()) {
				landlordRepository.delete(landlord);

			}
			return deletelandlord.get();

		} catch (Exception e) {
			throw new EntityDeletionException("landlord details are not valid");
		}
	}

	/*
	 * To display the landlord by Id (Primary key)
	 * 
	 * @param id: landlord id of the landlord.
	 * 
	 * @returns User if landlord with Id presents it returns user else throws
	 * UserNotFoundException
	 * 
	 * @throws UserNotFoundException It is raised due to invalid LandlordId
	 * 
	 */

	@Override
	public Landlord viewLandlord(int id) throws LandlordNotFoundException {
		try {
			Optional<Landlord> landlord = landlordRepository.findById(id);
			if (landlord.isPresent()) {
				return landlord.get();
			} else {
				throw new LandlordNotFoundException("Landlord is not found for Id " + id);
			}

		} catch (Exception e) {
			throw new LandlordNotFoundException(e.getMessage());

		}
	}

	/*
	 * To display all the landlord
	 * 
	 * @returns List<User> It returns all the landlord's present in database
	 */

	@Override
	public List<Landlord> viewAllLandlord() {
		List<Landlord> landlordlist = new ArrayList<Landlord>();
		try {
			landlordlist = landlordRepository.findAll();
			if (landlordlist.isEmpty()) {
				throw new EmptyEntityListException("No landlord found");

			} else {
				return landlordlist;
			}
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}
	}

}