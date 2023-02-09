package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.service.UserService;

@SpringBootTest

public class UserTests extends OnlineFlatRentalApplicationTests {

	@Autowired
	private UserService iUserServiceImpl;

	/**
	 * Description-For ViewUser test it will throw exception if it is fail
	 * @throws UserNotFoundException
	 */
	@Test
	public void testViewUser1() throws UserNotFoundException {
		User user = new User(80, "suresh", "1237890", "Landlord");
		iUserServiceImpl.addUser(user);
		assertEquals("suresh", iUserServiceImpl.viewUser(80).getUserName());
	}
	/**
	 * Description- For ViewUser test it will throw exception if it is fail
	 * @throws UserNotFoundException
	 */

	@Test
	public void testViewUser2() throws UserNotFoundException {
		User user = new User(90, "rajesh", "1237867", "Tenant");
		iUserServiceImpl.addUser(user);
		assertEquals("rajesh", iUserServiceImpl.viewUser(90).getUserName());
	}
	/**
	 * Description - For View All User Test
	 */

	@Test
	public void testViewAllUser1() {
		assertNotNull(iUserServiceImpl.viewAllUser());
	}
	/**
	 * Description - For View All User Test
	 */

	@Test
	public void testViewAllUser2() {
		assertNotNull(iUserServiceImpl.viewAllUser());
	}

	/**
	 * Description - For update User Test .It will throw Exception if it is fail
	 */
	@Test
	public void testUpdateUser1() throws UserNotFoundException {
		User user = new User(90, "rajesh", "1237867", "Tenant");
		iUserServiceImpl.addUser(user);
		user.setUserName("rakesh");
		iUserServiceImpl.updateUser(user);
		assertEquals("rakesh", iUserServiceImpl.viewUser(90).getUserName());
	}

	/**
	 * Description - For update User Test .It will throw Exception if it is fail
	 */
	@Test
	public void testUpdateUser2() throws UserNotFoundException {
		User user = new User(80, "suresh", "1237890", "Landlord");
		user.setUserType("Tenant");
		iUserServiceImpl.updateUser(user);
		assertEquals("Tenant", iUserServiceImpl.viewUser(80).getUserType());
	}

	/**
	 * Description - For Add user test.It will throw an Exception if it is fail
	 * @throws UserNotFoundException
	 */

	@Test
	public void testAddUser1() throws UserNotFoundException {
		User user = new User(30, "anil", "123456", "Landlord");
		iUserServiceImpl.addUser(user);
		assertEquals("anil", iUserServiceImpl.viewUser(30).getUserName());
	}

	/**
	 * Decription - For Remove User test
	 */

	@Test
	public void testRemoveUser1() {
		User user = new User(50, "ashok", "12378", "Tenant");
		iUserServiceImpl.addUser(user);
		User deletedUser = iUserServiceImpl.removeUser(user);
		assertEquals("ashok", deletedUser.getUserName());
	}


	/**
	 * Decription - For Remove User test
	 */

	@Test
	public void testRemoveUser2() {
		User user = new User(60, "ramesh", "123789", "Landlord");
		iUserServiceImpl.addUser(user);
		User deletedUser = iUserServiceImpl.removeUser(user);
		assertEquals(60, deletedUser.getUserId());
	}
}