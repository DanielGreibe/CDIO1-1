package TUI;

import java.util.List;
import java.util.Scanner;

import data.UserDTO;
import funktion.DataManager;
import funktion.IUserDAO;
import funktion.IUserDAO.DALException;

public class TUI {

	private DataManager data;
	private Scanner keyb;
	private boolean running;

	public TUI() {
		data = new DataManager();
		keyb = new Scanner(System.in);
		running = true;
	}

	public void mainMenu() throws DALException {
		System.out.println("--------------------------------------------------------");
		System.out.println("-");
		System.out.println("-\t Welcome to CRUD International!");
		System.out.println("-");
		System.out.println("--------------------------------------------------------");
		while (running) {
			System.out.println("");
			System.out.println("");
			System.out.println("What would you like to do?");
			System.out.println("");
			System.out.println("\t1. Create User");
			System.out.println("\t2. Read User");
			System.out.println("\t3. Update User");
			System.out.println("\t4. Delete User");
			System.out.println("\t5. See All Users");
			System.out.println("\t6. Exit Program");
			System.out.println("");
			switch (getUserInput()) {
			case 1:
				createUser();
				break;
			case 2:
				readUser();
				break;
			case 3:
				updateUser();
				break;
			case 4:
				deleteUser();
				break;
			case 5:
				seeAllUsers();
				break;
			case 6:
				running = false;
				break;
			default:
				System.out.println("Didn't understand input. Type an integer.");
			}
		}
		System.out.println("Program now exiting. Goodbye!");
	}

	private void seeAllUsers() throws DALException {

		System.out.println("Printing all users:");
		System.out.println("");
		List<UserDTO> userList = data.getUserList();
		if (userList.isEmpty())
			System.err.println("There are no users.");
		for (UserDTO userDTO : userList) {
			System.out.println(userDTO);
		}

	}

	private void deleteUser() throws DALException {
		int ID;
		System.out.println("Type User-ID of what User you wish to delete.");
		ID = keyb.nextInt();
		data.deleteUser(ID);
		System.out.println("User deleted.");

	}

	private void updateUser() throws DALException {
		// All attributes required.
		UserDTO tempUser = new UserDTO();
		String username = null;
		String initials = null;
		String CPR = null;
		int ID;
		String role = null;
		boolean moreRoles = true;

		System.out.println("You are now updating a user.");
		System.out.println("");

		System.out.println("Type User-ID of user you wish to change. List of all users is printed here:");
		seeAllUsers();
		do {
			ID = keyb.nextInt();
		} while (!checkUserExistsID(ID));
		tempUser.setUserId(ID);
		System.out.println("You wish to edit user with ID " + tempUser.getUserId());
		System.out.println("");

		System.out.println("Type new username. Must be atleast 2 and maximally 20 characters");
		do {
			username = keyb.next();
		} while (!checkUsername(username));
		tempUser.setUserName(username);
		System.out.println("New name set as " + tempUser.getUserName());
		System.out.println("");

		System.out.println("Type new initials. Must be atleast 2 and maximally 4 characters");
		do {
			initials = keyb.next();
		} while (!checkInitials(initials));
		tempUser.setIni(initials);
		System.out.println("Initials set as " + tempUser.getIni());
		System.out.println("");

		System.out.println("Type new CPR-number.");
		CPR = keyb.next();
		tempUser.setCPR(CPR);
		System.out.println("CPR set as " + tempUser.getCPR());
		System.out.println("");

		while (moreRoles) {
			System.out.println("Type a role to add to the user. You must retype all established roles. Type DONE to finish.");
			role = keyb.next();
			if (role.equals("DONE"))
				break;
			tempUser.addRole(role);
			System.out.println("");
		}
		System.out.println("");
		System.out.println("User update complete. Saving to datamanager.");
		data.updateUser(tempUser);
		System.out.println("Saving to datamanager successful.");
	}
	
	private boolean checkUserExistsID(int iD) throws DALException {
		List<UserDTO> tempUserList = data.getUserList();
			for (int i = 0; i < tempUserList.size(); i++) {
				if (tempUserList.get(i).getUserId() == iD) {
					System.out.println("User found.");
					return true;
				}
			}
		System.out.println("User-ID does not exist already. Try again.");
		return false;
	}

	// TODO Make printout much nicer.
	private void readUser() throws DALException {
		UserDTO tempUser = null;
		int ID;
		System.out.println("Type User-ID of what User you wish to read.");
		ID = keyb.nextInt();
		tempUser = data.getUser(ID);
		if (tempUser != null && tempUser.getUserName() != null)
			System.out.println(tempUser.toString());
		else
			System.err.println("Could not find user.");

	}

	private void createUser() throws DALException {
		// All attributes required.
		UserDTO tempUser = new UserDTO();
		String username = null;
		String initials = null;
		String CPR = null;
		int ID;
		String role = null;
		boolean moreRoles = true;

		System.out.println("You are now creating a user.");
		System.out.println("");

		System.out.println("Type a username. Must be atleast 2 and maximally 20 characters");
		do {
			username = keyb.next();
		} while (!checkUsername(username));
		tempUser.setUserName(username);
		System.out.println("Name set as " + tempUser.getUserName());
		System.out.println("");

		System.out.println("Type initials. Must be atleast 2 and maximally 4 characters");
		do {
			initials = keyb.next();
		} while (!checkInitials(initials));
		tempUser.setIni(initials);
		System.out.println("Initials set as " + tempUser.getIni());
		System.out.println("");

		System.out.println("Type CPR-number.");
		CPR = keyb.next();
		tempUser.setCPR(CPR);
		System.out.println("CPR set as " + tempUser.getCPR());
		System.out.println("");

		System.out.println("Type a User-ID. Must be between and including 11 to 99");
		do {
			ID = keyb.nextInt();
		} while (!checkUserID(ID));
		tempUser.setUserId(ID);
		System.out.println("User-ID set as " + tempUser.getUserId());
		System.out.println("");

		while (moreRoles) {
			System.out.println("Type a role to add to the user. Type DONE to finish.");
			role = keyb.next();
			if (role.equals("DONE"))
				break;
			tempUser.addRole(role);
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Users password is: " + tempUser.getPassword());
		System.out.println("");
		System.out.println("User creation complete. Saving to datamanager.");
		data.createUser(tempUser);
		System.out.println("Saving to datamanager successful.");
	}

	private boolean checkUserID(int iD) throws DALException {
		List<UserDTO> tempUserList = data.getUserList();
		if (iD >= 11 && iD <= 99) {
			for (int i = 0; i < tempUserList.size(); i++) {
				if (tempUserList.get(i).getUserId() == iD) {
					System.out.println("User-ID is invalid. Try again.");
					return false;
				}
			}
			return true;
		}
		System.out.println("User-ID is invalid. Try again.");
		return false;
	}

	private boolean checkInitials(String initials) {
		if (initials.length() >= 2 && (initials.length()) <= 4)
			return true;
		System.out.println("Initials are invalid. Try again.");
		return false;
	}

	private boolean checkUsername(String username) {
		if (username.length() >= 2 && (username.length()) <= 20)
			return true;
		System.out.println("Username is invalid. Try again.");
		return false;
	}

	private int getUserInput() {
		int input;
		input = keyb.nextInt();
		return input;
	}

}
