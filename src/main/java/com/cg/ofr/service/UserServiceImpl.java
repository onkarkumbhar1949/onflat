package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.UserRepository;

/*     It is a user service implementation class that defines the methods
 *                           mentioned in its interface.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * To display the user by Id (Primary key)
	 * 
	 * @param id: id of the user.
	 * 
	 * @throws EntityNotFoundException
	 * 
	 * @returns User - if user with Id presents it returns user else throws
	 * UserNotFoundException
	 * 
	 * @throws UserNotFoundException - It is raised due to invalid UserId
	 */
	@Override
	public User viewUser(int id) throws UserNotFoundException {
		try {
			Optional<User> user = userRepository.findById(id);
			if (user.isPresent()) {
				return user.get();
			} else {
				throw new UserNotFoundException("User is not found for Id " + id);
			}

		} catch (Exception e) {
			throw new UserNotFoundException(e.getMessage());

		}

	}

	/*
	 * To display all the users
	 * 
	 * @throws EmptyEntityListException
	 * 
	 * @returns List<User> - It returns all the users present in database
	 */
	@Override
	public List<User> viewAllUser() {
		try {
			List<User> userList = userRepository.findAll();
			if (userList.isEmpty()) {
				throw new EmptyEntityListException(" No Users found");
			} else {
				return userList;
			}
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}

	}

	/*
	 * It is used to verify username and password of user
	 * 
	 * @param username: username for validating user.
	 * 
	 * @param password: password for validating user.
	 * 
	 * @throws EntityNotFoundException
	 * 
	 * @returns User - it returns user details if the details are correct else it
	 * throws UserNotFoundException
	 * 
	 * @throws UserNotFoundException - It is raised due to invalid username or
	 * password.
	 */
	@Override
	public User validateUser(String username, String password) throws UserNotFoundException {
		try {
			Optional<User> user = userRepository.findByuserName(username);
			if (user.isPresent()) {
				if (username.equals(user.get().getUserName()) && (password.equals(user.get().getPassword()))) {
					return user.get();
				} else {
					throw new UserNotFoundException("Password does not match for " + username);
				}
			} else {
				throw new UserNotFoundException("User is not there with username :" + username);
			}
		} catch (Exception e) {
			throw new UserNotFoundException(e.getMessage());
		}
	}

	/*
	 * It is used to add user into user_details table
	 * 
	 * @param user: User's reference variable.
	 * 
	 * @throws EntityCreationException
	 * 
	 * @returns User It returns user with details
	 */
	@Override
	public User addUser(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new EntityCreationException("Valid details of user are not entered");
		}
	}

	/*
	 * It is used to update user details into user_details table.
	 * 
	 * @param user: User's reference variable.
	 * 
	 * @throws EntityUpdationException
	 * 
	 * @returns User It returns updated details of the existed user.
	 */
	@Override
	public User updateUser(User user) {
		try {
			Optional<User> user1 = userRepository.findById(user.getUserId());
			if (user1.isPresent()) {
				return userRepository.save(user);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityUpdationException("No updation found");
		}

	}

	/*
	 * It is used to update password
	 * 
	 * @param user: User's reference variable.
	 * 
	 * @param newpass: new password for user.
	 * 
	 * @throws EntityNotFoundException
	 * 
	 * @throws UserNotFoundException
	 * 
	 * @returns User It returns updated details of the existed user.
	 */
	@Override
	public User updatePassword(User user, String newpass) throws UserNotFoundException {
		try {
			Optional<User> checkuser = userRepository.findByuserName(user.getUserName());
			Optional<User> checkuser1 = Optional
					.of(validateUser(checkuser.get().getUserName(), checkuser.get().getPassword()));
			if (checkuser1.isPresent()) {
				user.setPassword(newpass);
				userRepository.save(user);
				return user;
			} else {
				throw new UserNotFoundException("No user found");
			}

		} catch (Exception e) {
			throw new UserNotFoundException(e.getMessage());
		}
	}

	/*
	 * It is used to remove user
	 * 
	 * @param user: User's reference variable.
	 * 
	 * @throws EntityDeletionException
	 * 
	 * @returns User It returns the user that has been deleted
	 * 
	 * @throws UserNotFoundException: It is raised due to invalid user.
	 */
	@Override
	public User removeUser(User user) {
		try {
			Optional<User> deletedUser = userRepository.findById(user.getUserId());
			if (deletedUser.isPresent()) {
				userRepository.delete(user);
			}
			return deletedUser.get();
		} catch (Exception e) {
			throw new EntityDeletionException("Invalid user details");
		}

	}

}