package test;

import java.io.IOException;

import funktion.*;
import data.*;


public class MainTest {
	
	public static void main(String[] args) {
		try {
			ScaleApplication scale = new ScaleApplication();
			Client client = new Client();
			
			client.Connect("169.254.2.3", 8000);
			client.SendCommand("Indtast ID");
			scale.waitForConfirmation();
//			scale.AskForID();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}