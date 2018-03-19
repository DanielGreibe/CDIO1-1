package funktion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Scale 
{
	Scanner keyboard = new Scanner(System.in);
	Socket scaleSocket;
	BufferedReader reader;
	BufferedWriter writer;
	
	public void Connect(String IP, int Portnumber) {
		try {
			// Makes a Scanner that is used to read the input to the Scale.

			// Makes a Socket with String input as the IP and Int input as Port.
			scaleSocket = new Socket(IP, Portnumber);

			// Makes a Socket with 169.254.2.2 as the IP and 8000 as Port.
			// socketClient = new Socket("169.254.2.2",8000);
			System.out.println("Client: " + "Connection Established");

			// Makes a BufferedReader and Writer to write and read from the Socket.
			reader = new BufferedReader(new InputStreamReader(scaleSocket.getInputStream()));

			writer = new BufferedWriter(new OutputStreamWriter(scaleSocket.getOutputStream()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeText(String text) {
		try {
			writer.write("D " + "\"" + text + "\"" + "\r\n");
			writer.flush();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void WriteText2(String text)
	{
		writeText(text);
	}

	public String ReadOutput() {
		String output = null;
		try {
			if ((output = reader.readLine()) != null) {
				// Prints out the answer received from the scale.
				System.out.println("Client: " + output);
				return output;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}