package TUI;

import java.util.Scanner;

import funktion.IUserDAO.DALException;

public class TUI {

	private Scanner keyb;

	public TUI() {
		keyb = new Scanner(System.in);
	}
	
	public void printText(String input) { 
		System.out.println(input);
	}
	
	public String mainMenu() throws DALException {
		System.out.println("");
		System.out.println("MAIN MENU");
		System.out.println("What would you like to do?");
		System.out.println("");
		System.out.println("\t1. Perform Weight");
		System.out.println("\t2. Create/Read/Update/Delete User");
		System.out.println("\t3. Exit program.");
		System.out.println("");
		switch (nextInt()) {
		case 1:
			return "weight";
		case 2:
			return "crud";
		case 3:
			return "quit";
		default:
			return "fail";
		}
	}

	public String CRUDMenu() throws DALException {
			System.out.println("");
			System.out.println("CRUD MENU");
			System.out.println("What would you like to do?");
			System.out.println("");
			System.out.println("\t1. Create User");
			System.out.println("\t2. Read User");
			System.out.println("\t3. Update User");
			System.out.println("\t4. Delete User");
			System.out.println("\t5. See All Users");
			System.out.println("\t6. Exit CRUD menu");
			System.out.println("");
			switch (nextInt()) {
			case 1:
				return "createUser";
			case 2:
				return "readUser";
			case 3:
				return "updateUser";
			case 4:
				return "deleteUser";
			case 5:
				return "seeAllUsers";
			case 6:
				return "exit";
			default:
				return "fail";
			}
		}


	public int nextInt() {
		return keyb.nextInt();
	}

	public String nextString() {
		return keyb.next();
	}

	public void waitForEnter() {
		keyb.nextLine();
	}
}
