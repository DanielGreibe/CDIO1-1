package funktion;

import funktion.IUserDAO.DALException;

public class ScaleApplication 
{
	DataManager datalag = new DataManager();
	int tareWeight;
	/**
	 * Method to write text to the Scale with a String as input.
	 * The String represents the text that is sent to the scale.
	 */
	public void writeText(String text)
	{
		//Nedenstående er commanden for at skrive tekst til vægten.
		//Hvordan det virker? Dunno.
		String scaleCommand = "D " + text + "crlf";
		//Weight.Input(scaleCommand);
	}
	
	public boolean waitForConfirmation()
	{
		if (Weight.buttonPressed = "OK")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getScaleInput()
	{
//		return Scale.getValue()
		return "InsertScaleInputHere";
	}
	
	public void AskForID() throws DALException
	{
		//Først skrives til vægten, venter på et okay, tager værdien fra vægten
		//og henter brugeren med samme ID og udskriver navnen på den bruger
		//og venter til sidst på et ok fra brugeren.
		writeText("Indtast ID");
		waitForConfirmation();
		String StringID = getScaleInput();	
		int ID = Integer.parseInt(StringID);
		String username = datalag.getUser(ID).getUserName();
		writeText(username);
		waitForConfirmation();	
	}
	
	public void askForBatch() throws DALException
	{
		writeText("Indtast ID");
		waitForConfirmation();
		String StringBatch = getScaleInput();	
		int Batch = Integer.parseInt(StringBatch);
//		Hent Batch værdien.
//		Skriv tekst med Batchen ud til brugeren med writeText
		waitForConfirmation();
	}
	
	public void resetScale()
	{
		writeText("Clear Scale");
		waitForConfirmation();
	}
	
	public void saveTare()
	{
//		tareWeight = Send input to Scale ("S clrf");
		
	}
	
	
	
}
