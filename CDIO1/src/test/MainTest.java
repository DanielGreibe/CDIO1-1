package test;

import java.io.IOException;

import funktion.*;
import data.*;


public class MainTest {
	
	public static void main(String[] args) throws IOException {
		try {
			//SETUP
			Scale scale = new Scale();
			ScaleApplication sc = new ScaleApplication();
			
			//FUNCTION
			scale.Connect("169.254.2.3", 8000);
			scale.askForInput("Indtast ID");
			System.out.println(scale.readOutputAndSplit());
			
			
			//CATCH EXCEPTIONS
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}