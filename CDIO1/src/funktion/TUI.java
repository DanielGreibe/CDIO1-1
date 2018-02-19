package funktion;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import data.UserDTO;
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

	public void mainMenu() {
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

	private void seeAllUsers() {
		
		System.out.println("Printing all users:");
		System.out.println("");
		try {
			List<UserDTO> userList = data.getUserList();
			if (userList.isEmpty())
				System.err.println("There are no users.");
			for (UserDTO userDTO : userList) {
				System.out.println(userDTO);
			}
		} catch (DALException e) {
			System.err.println("Could not recieve UserList from Data");
			e.printStackTrace();
		}
		
	}

	private void deleteUser() {
		int ID;
		System.out.println("Type User-ID of what User you wish to delete.");
		ID = keyb.nextInt();
		try {
			data.deleteUser(ID);
		} catch (DALException e) {
			System.err.println("Could not delete user - probably didn't exist.");
			e.printStackTrace();
		}
		System.out.println("User deleted.");
		
	}

	private void updateUser() {
		// TODO Auto-generated method stub
		
	}

	// TODO Make printout much nicer.
	private void readUser() {
		UserDTO tempUser = null;
		int ID;
		System.out.println("Type User-ID of what User you wish to read.");
		ID = keyb.nextInt();
		try {
			tempUser = data.getUser(ID);
		} catch (DALException e) {
			System.err.println("Could not get user, hit DALException.");
			e.printStackTrace();
		}
		if (tempUser != null && tempUser.getUserName() != null)
			System.out.println(tempUser.toString());
		else
			System.err.println("Could not find user.");

	}

	private void createUser() {
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
		System.out.println("User creation complete. Saving to datamanager.");
		try {
			data.createUser(tempUser);
			System.out.println("Saving to datamanager successful.");
		} catch (DALException e) {
			System.err.println("Could not save to datamanager due to DALException.");
			e.printStackTrace();
		}
	}

	private boolean checkUserID(int iD) {
		try {
			List<UserDTO> tempUserList = data.getUserList();
			for (UserDTO i: tempUserList) {
				if (i.getUserId() == iD)
					System.out.println("User-ID is invalid. Try again.");
					return false;
			}
		} catch (DALException e) {
			System.err.println("Could not get user list in checkID.");
			e.printStackTrace();
		}
		if (iD >= 11 && iD <= 99)
			
			return true;
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
