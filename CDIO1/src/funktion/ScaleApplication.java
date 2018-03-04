package funktion;

import java.util.List;

import TUI.TUI;
import data.UserDTO;
import funktion.IUserDAO.DALException;

public class ScaleApplication {

	private boolean running = true;
	DataManager datalag = new DataManager();
	int tareWeight;
	TUI textInterface = new TUI();
	String print;

	/**
	 * Method to write text to the Scale with a String as input. The String
	 * represents the text that is sent to the scale.
	 * 
	 * @throws DALException
	 */

	public ScaleApplication() throws DALException {
		print = "--------------------------------------------------------\n-\n\t Welcome to Scale Application.\n-\n--------------------------------------------------------";
		textInterface.printText(print);

		// TODO: This shouldn't run before actually asked by a main menu method.
		CRUDMenu();

	}

	public void CRUDMenu() throws DALException {
		String action;
		while (running) {
			action = textInterface.mainMenu();
			switch (action) {
			case "createUser":
				createUser();
				break;
			case "readUser":
				readUser();
				break;
			case "updateUser":
				updateUser();
				break;
			case "deleteUser":
				deleteUser();
				break;
			case "seeAllUsers":
				seeAllUsers();
				break;
			case "exit":
				running = false;
				break;
			default:
				print = "Did not understand query. Please retry.";
				textInterface.printText(print);
				break;
			}
		}
	}

	public void seeAllUsers() throws DALException {

		textInterface.printText("Printing all users.");
		List<UserDTO> userList = datalag.getUserList();
		if (userList.isEmpty())
			textInterface.printText("There are no users.");
		for (UserDTO userDTO : userList) {
			textInterface.printText(userDTO.toString());
		}

	}

	public void deleteUser() throws DALException {
		int ID;
		textInterface.printText("Type ID of user you wish to delete.");
		ID = textInterface.nextInt();
		datalag.deleteUser(ID);
		textInterface.printText("User deleted.");

	}

	public void updateUser() throws DALException {
		// All attributes required.
		UserDTO tempUser = new UserDTO();
		String username = null;
		String initials = null;
		String CPR = null;
		int ID;
		String role = null;
		boolean moreRoles = true;

		textInterface.printText("You are now updating a user.\n");

		textInterface.printText("Type ID of user you wish to change. All users are printed here: \n");
		seeAllUsers();
		do {
			ID = textInterface.nextInt();
		} while (!checkUserExistsID(ID));
		tempUser.setUserId(ID);
		print = "You wish to edit user with ID " + tempUser.getUserId();
		textInterface.printText(print);

		print = "Type a username between 2 and 20 characters long.";
		textInterface.printText(print);
		do {
			username = textInterface.nextString();
		} while (!checkUsername(username));
		tempUser.setUserName(username);
		print = "New name set as " + tempUser.getUserName();
		textInterface.printText(print);

		print = "Type initials between 2 and 4 characters long.";
		textInterface.printText(print);
		do {
			initials = textInterface.nextString();
		} while (!checkInitials(initials));
		tempUser.setIni(initials);
		print = "New initials set as " + tempUser.getIni();
		textInterface.printText(print);

		textInterface.printText("Type CPR-Number.");
		CPR = textInterface.nextString();
		tempUser.setCPR(CPR);
		print = "New CPR set as " + tempUser.getCPR();
		textInterface.printText(print);

		while (moreRoles) {
			textInterface.printText("Type a role to add to the user. Type DONE to finish.\n");
			role = textInterface.nextString();
			if (role.equals("DONE"))
				break;
			tempUser.addRole(role);
			textInterface.printText("Role added.");
		}
		System.out.println("");
		print = "User creation complete. Saving to datamanager...";
		textInterface.printText(print);
		datalag.updateUser(tempUser);
		textInterface.printText("Saving to datamanager successful.");
	}

	public boolean checkUserExistsID(int iD) throws DALException {
		List<UserDTO> tempUserList = datalag.getUserList();
		for (int i = 0; i < tempUserList.size(); i++) {
			if (tempUserList.get(i).getUserId() == iD) {
				textInterface.printText("User found.");
				return true;
			}
		}
		textInterface.printText("User not found.");
		return false;
	}

	public void readUser() throws DALException {
		UserDTO tempUser = null;
		int ID;
		textInterface.printText("Type User-ID of user you wish to see.");
		ID = textInterface.nextInt();
		tempUser = datalag.getUser(ID);
		if (tempUser != null && tempUser.getUserName() != null)
			textInterface.printText(tempUser.toString());
		else
			textInterface.printText("Could not find user.");

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

		print = "You are now creating a user.\n";
		textInterface.printText(print);

		print = "Type a username between 2 and 20 characters long.";
		textInterface.printText(print);
		do {
			username = textInterface.nextString();
		} while (!checkUsername(username));
		tempUser.setUserName(username);
		print = "Name set as " + tempUser.getUserName() + "\n";
		textInterface.printText(print);

		print = "Type initials between 2 and 4 characters long.";
		textInterface.printText(print);
		do {
			initials = textInterface.nextString();
		} while (!checkInitials(initials));
		tempUser.setIni(initials);
		print = "Initials set as " + tempUser.getIni() + "\n";
		textInterface.printText(print);

		textInterface.printText("Type CPR-Number.");
		CPR = textInterface.nextString();
		tempUser.setCPR(CPR);
		print = "CPR set as " + tempUser.getCPR() + "\n";
		textInterface.printText(print);

		textInterface.printText("Type User-ID. Must be between 11 and 99.");
		do {
			ID = textInterface.nextInt();
		} while (!checkUserID(ID));
		tempUser.setUserId(ID);
		print = "User-ID set as " + tempUser.getCPR() + "\n";
		textInterface.printText(print);

		while (moreRoles) {
			textInterface.printText("Type a role to add to the user. Type DONE to finish.\n");
			role = textInterface.nextString();
			if (role.equals("DONE"))
				break;
			tempUser.addRole(role);
			textInterface.printText("Role added.");
		}
		print = "Users password is: " + tempUser.getPassword() + "\nUser creation complete. Saving to datamanager...";
		textInterface.printText(print);
		datalag.createUser(tempUser);
		textInterface.printText("Saving to datamanager successful.");
	}

	public boolean checkUserID(int iD) throws DALException {
		List<UserDTO> tempUserList = datalag.getUserList();
		if (iD >= 11 && iD <= 99) {
			for (int i = 0; i < tempUserList.size(); i++) {
				if (tempUserList.get(i).getUserId() == iD) {
					textInterface.printText("User-ID invalid. Try again.");
					return false;
				}
			}
			return true;
		}
		textInterface.printText("User-ID invalid. Try again.");
		return false;
	}

	public boolean checkInitials(String initials) {
		if (initials.length() >= 2 && (initials.length()) <= 4)
			return true;
		textInterface.printText("Initials invalid. Try again.");
		return false;
	}

	public boolean checkUsername(String username) {
		if (username.length() >= 2 && (username.length()) <= 20)
			return true;
		textInterface.printText("Username invalid. Try again.");
		return false;
	}

	public void writeText(String text) {
		// Nedenst�ende er commanden for at skrive tekst til v�gten.
		// Hvordan det virker? Dunno.
		String scaleCommand = "D " + text + "crlf";
		// Weight.Input(scaleCommand);
	}

	/* Hvad er Weight? */
	public boolean waitForConfirmation() {
		if (Weight.buttonPressed = "OK") {
			return true;
		} else {
			return false;
		}
	}

	public String getScaleInput() {
		// return Scale.getValue()
		return "InsertScaleInputHere";
	}

	public void AskForID() throws DALException {
		// F�rst skrives til v�gten, venter p� et okay, tager v�rdien fra v�gten
		// og henter brugeren med samme ID og udskriver navnen p� den bruger
		// og venter til sidst p� et ok fra brugeren.
		writeText("Indtast ID");
		waitForConfirmation();
		String StringID = getScaleInput();
		int ID = Integer.parseInt(StringID);
		String username = datalag.getUser(ID).getUserName();
		writeText(username);
		waitForConfirmation();
	}

	public void askForBatch() throws DALException {
		writeText("Indtast ID");
		waitForConfirmation();
		String StringBatch = getScaleInput();
		int Batch = Integer.parseInt(StringBatch);
		// Hent Batch v�rdien.
		// Skriv tekst med Batchen ud til brugeren med writeText
		waitForConfirmation();
	}

	public void resetScale() {
		writeText("Clear Scale");
		waitForConfirmation();
	}

	public void saveTare() {
		// tareWeight = Send input to Scale ("S clrf");

	}

}
