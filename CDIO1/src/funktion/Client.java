package funktion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	Scanner keyboard = new Scanner(System.in);
	Socket socketClient;
	BufferedReader reader;
	BufferedWriter writer;

	public void Connect(String IP , int Portnumber) throws IOException
	{
		try
		{
			//Makes a Scanner that is used to read the input to the Scale.

			//Makes a Socket with String input as the IP and Int input as Port.
			socketClient = new Socket(IP,Portnumber);
			
			
			//Makes a Socket with 169.254.2.2 as the IP and 8000 as Port.
//			socketClient = new Socket("169.254.2.2",8000);
			System.out.println("Client: "+"Connection Established");

			//Makes a BufferedReader and Writer to write and read from the Socket.
			reader = 
					new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

			writer = 
					new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));  

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void SendCommand(String Command) throws IOException
	{
<<<<<<< HEAD
	//	Command = keyboard.nextLine();
		writer.write("D" + Command +"\r\n");
=======
		Command = keyboard.nextLine();
		writer.write("D" + "\"" + "\"" + "\r\n");
>>>>>>> branch 'master' of https://github.com/DanielGreibe/CDIO1-1.git
		writer.flush();
	}


	public String ReadOutput() throws IOException
	{
		String output;
		if((output = reader.readLine()) != null)
		{
			//Prints out the answer received from the scale.
			System.out.println("Client: " + output);
			return output;
		}
		else
		{
			return output;
		}
	}
}