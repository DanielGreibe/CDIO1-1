package test;

import java.util.List;

import dal.IUserDAO.DALException;
import data.UserDTO;
import funktion.DataManager;

public class DBTesterJUnit {

	void test() {

	DataManager data = new DataManager();
	UserDTO newUser = new UserDTO();

	printUsers(data);

	newUser.setIni("test");
	newUser.addRole("Admin");
	newUser.setUserName("testName");
	newUser.setUserId(30);
	try {
		data.createUser(newUser);
	} catch (funktion.IUserDAO.DALException e) {
		e.printStackTrace();
	}

	try {
		data.createUser(newUser);
	} catch (funktion.IUserDAO.DALException e) {
		// TODO This part should FAIL - make sure Datamanager doesn't duplicate users.
		e.printStackTrace();
	}

	newUser.setUserId(1);
	newUser.setUserName("2NDuser");
	try {
		data.createUser(newUser);
	} catch (funktion.IUserDAO.DALException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	printUsers(data);
	newUser.setUserId(0);
	newUser.setUserName("ModifiedName");
	try {
		data.updateUser(newUser);
	} catch (funktion.IUserDAO.DALException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	printUsers(data);
	
	try {
		data.deleteUser(11);
	} catch (funktion.IUserDAO.DALException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	printUsers(data);
	
	// TODO Add fail statement.
//	fail("Not yet implemented");
}

	private static void printUsers(DataManager iDAO) {
		try {
			System.out.println("Printing users...");
			List<UserDTO> userList = iDAO.getUserList();
			for (UserDTO userDTO : userList) {
				System.out.println(userDTO);
			}

		} catch (funktion.IUserDAO.DALException e) {
			e.printStackTrace();
		}
	}

}
