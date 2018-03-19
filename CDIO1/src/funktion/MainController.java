package funktion;

import java.io.IOException;

import TUI.TUI;
import funktion.IUserDAO.DALException;

public class MainController {

	public MainController() {
		try {
			ScaleApplication ScaleApp = new ScaleApplication();
			ScaleApp.MainMenu();
		} catch (DALException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
