package com.cg.ofr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.service.UserService;

/*
 * Description:        It is a controller class that controls the
 *                      data flow into model object and updates the view whenever data changes 
 */

@RestController
public class UserController {

	@Autowired
	private UserService iUserServiceImpl;

	/*
	 * Method:          viewUser 
	 * Description:     To display the user by Id (Primary key)
	 * 
	 * @param id:       id of the user.
	 * @returns User - if user with Id presents it returns user else throws
	 *                  UserNotFoundException
	 * @throws UserNotFoundException - It is raised due to invalid UserId
	 * @GetMapping: It is used to handle GET type of request method.
	 * @PathVariable: It is used for data passed in the URI and transfer its values
	 *                to parameter variables. 
	 */

	@GetMapping("/user/{id}")
	public User viewUser(@PathVariable int id) throws UserNotFoundException {
		return iUserServiceImpl.viewUser(id);
	}

	/*
	 * Method: viewAllUser 
	 * Description: To display all the users
	 * 
	 * @returns List<User> - It returns all the users present in database
	 * @GetMapping: It is used to handle GET type of request method. 
	 */
	@GetMapping("/users")
	public List<User> viewAllUser() {
		return iUserServiceImpl.viewAllUser();
	}

	/*
	 * Method: validateUser
	 *  Description: It is used to verify username and password of user
	 * 
	 * @param username: username for validating user.
	 * @param password: password for validating user.
	 * @returns User - it returns user details if the details are correct else it
	 *          throws UserNotFoundException
	 * @throws UserNotFoundException - It is raised due to invalid username or
	 *                               password.
	 * @GetMapping: It is used to is used to handle GET type of request method.
	 * @PathVariable: It is used for data passed in the URI and transfer its values
	 *                to parameter variables. 
	 */
	@GetMapping("/getvalidate/{username}/{password}")
	public User validateUser(@PathVariable String username, @PathVariable String password) throws UserNotFoundException {
		return iUserServiceImpl.validateUser(username, password);
	}

	/*
	 * Method: addUser 
	 * Description: It is used to add user into user_details table
	 * 
	 * @param user: User's reference variable.
	 * @returns User It returns user with details
	 * @PostMapping: It is used to handle POST type of request method
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 */
	@PostMapping("/user")
	public User addUser(@Valid @RequestBody User user) {
		return iUserServiceImpl.addUser(user);
	}

	/*
	 * Method: updateUser
	 *  Description: It is used to update user details into
	 * user_details table.
	 * 
	 * @param user: User's reference variable.
	 * @returns User It returns updated details of the existed user.
	 * @PuttMapping: It is used to handle PUT type of request method
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 */
	@PutMapping("/user")
	public User updateUser(@Valid @RequestBody User user) {
		return iUserServiceImpl.updateUser(user);
	}

	/*
	 * Method: updatePassword
	 *  Description: It is used to update password
	 * 
	 * @param user:    User's reference variable.
	 * @param newpass: new password for user.
	 * @throws UserNotFoundException
	 * @returns User It returns updated details of the existed user.
	 * @PuttMapping: It is used to handle PUT type of request method.
	 * @PathVariable: It is used for data passed in the URI and transfer its values
	 *                to parameter variables.
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 */
	@PutMapping("/updatepassword/{newpass}")
	public User updatePassword(@RequestBody User user, @PathVariable String newpass) throws UserNotFoundException {
		return iUserServiceImpl.updatePassword(user, newpass);
	}

	/*
	 * Method: removeUser 
	 * Description: It is used to remove user
	 * 
	 * @param user: User's reference variable.
	 * @returns User It returns the user that has been deleted
	 * @throws UserNotFoundException: It is raised due to invalid user.
	 * @DeleteMapping: It is used to handle DELETE type of request method.
	 * @RequestBody: It maps the HttpRequest body to a transfer or domain object
	 */
	@DeleteMapping("/user")
	public User removeUser(@Valid @RequestBody User user) {
		return iUserServiceImpl.removeUser(user);
	}

}