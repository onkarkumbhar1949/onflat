package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.FlatRepository;

/*
 		It is a flat service implementation class
 *         			that defines the methods mentioned in its interface. 
*/

@Service
@Transactional
public class FlatServiceImpl implements FlatService {

	@Autowired
	private FlatRepository flatRepository;

	/*
	 * Method: addFlat Description: It is used to add flat into flat table
	 * 
	 * @param user: Flat's reference variable.
	 * 
	 * @returns Flat It returns user with details
	 * 
	 */

	@Override
	public Flat addFlat(Flat flat) {
		try {
			Flat flat1 = null;
			flat1 = flatRepository.save(flat);
			return flat1;
		} catch (Exception e) {
			throw new EntityCreationException("valid details of flat is not entered");

		}

	}

	/*
	 * It is used to update flat details into flat table.
	 * 
	 * @param flat: Flat's reference variable.
	 * 
	 * @returns Flat : It returns updated details of the existed flat.
	 * 
	 */

	@Override
	public Flat updateFlat(Flat flat) {
		Flat flat1 = null;
		try {
			if (flatRepository.existsById(flat.getFlatId())) {
				flat1 = flatRepository.save(flat);

			} else {
				throw new FlatNotFoundException("No flat found with id :" + flat.getFlatId() + " To update");
			}
		} catch (Exception e) {
			throw new EntityUpdationException(e.getMessage());
		}
		return flat1;

	}

	/*
	 *  It is used to delete flat
	 * 
	 * @param flat: Flat's reference variable.
	 * 
	 * @returns Flat : It returns the flat that has been deleted
	 * 
	 * @throws EntityNotFoundException: It is raised due to invalid user.
	 * 
	 **/

	@Override
	public Flat deleteFlat(Flat flat) {

		try {
			if (flatRepository.existsById(flat.getFlatId())) {
				Flat flat1 = flat;
				flatRepository.deleteById(flat1.getFlatId());
				return flat1;
			} else
				throw new FlatNotFoundException("flat not available with id " + flat.getFlatId() + " to delete");
		} catch (Exception e) {
			throw new EntityDeletionException(e.getMessage());
		}
	}

	/*
	 * To display the flat by Id (Primary key)
	 * 
	 * @param id: id of the flat.
	 * 
	 * @returns flat - if flat with Id presents it returns flat else throws
	 * EntityNotFoundException
	 * 
	 * @throws FlatNotFoundException
	 * 
	 */

	@Override
	public Flat viewFlat(int id) throws FlatNotFoundException {
		Flat flat1 = null;
		try {
			if (flatRepository.findById(id).isPresent()) {
				flat1 = flatRepository.findById(id).get();
				return flat1;
			} else {
				throw new FlatNotFoundException("Flat with id " + id + " was not found");

			}

		} catch (Exception e) {
			throw new FlatNotFoundException(e.getMessage());
		}

	}

	/*
	 * To display all the flats
	 * 
	 * @returns List<Flat> It returns all the flats present in database
	 * 
	*/

	@Override
	public List<Flat> viewAllFlat() {
		List<Flat> allFlats = new ArrayList<Flat>();

		try {

			allFlats = flatRepository.findAll();
			if (allFlats.isEmpty()) {
				throw new EmptyEntityListException("No Flats Found");
			} else
				return allFlats;
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());

		}

	}

	

	@Override
	public List<Flat> viewAllFlatByCost(float cost, String availability) {

		List<Flat> allFlatsByCostAndavailability = flatRepository.viewAllFlatByCostAndAvailability(cost, availability);
		try {
			if (allFlatsByCostAndavailability.isEmpty()) {
				throw new EmptyEntityListException(
						"No Flats Found with cost = " + cost + " And availability = " + availability);
			} else
				return allFlatsByCostAndavailability;

		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}

	}

}