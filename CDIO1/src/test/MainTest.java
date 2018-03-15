package test;

import java.io.IOException;

import funktion.Client;
import funktion.IUserDAO.DALException;
import funktion.ScaleApplication;

public class MainTest {
	
	public static void main(String[] args) {
		try {
			ScaleApplication scale = new ScaleApplication();
			Client client = new Client();
			
			client.Connect("169.254.2.3", 8000);
			client.SendCommand("iurjf");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}