package funktion;

import GUI.TUI;
import funktion.IUserDAO.DALException;

public class MainController {
	
	public MainController() {
		
		TUI Interface = new TUI();
		try {
			Interface.mainMenu();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}
