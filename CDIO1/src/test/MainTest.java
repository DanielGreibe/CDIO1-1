package test;

import java.io.IOException;

import funktion.*;
import data.*;


public class MainTest {
	
	public static void main(String[] args) throws IOException {
		try {
			//SETUP
			ScaleApplication applicationLayer = new ScaleApplication();
			Scale scale = new Scale();
			
			
			//FUNCTION
			scale.Connect("169.254.2.3", 8000);
			scale.WriteText2("Test2");
			applicationLayer.writeText("Test1");
			
			
			//CATCH EXCEPTIONS
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}