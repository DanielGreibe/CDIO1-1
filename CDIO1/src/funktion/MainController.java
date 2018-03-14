package funktion;

import TUI.TUI;
import funktion.IUserDAO.DALException;

public class MainController {

	public MainController() {
		try {
			ScaleApplication ScaleApp = new ScaleApplication();
			ScaleApp.CRUDMenu();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}
