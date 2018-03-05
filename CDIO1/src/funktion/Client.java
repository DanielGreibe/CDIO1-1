package funktion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
 
public class Client {
 
   public static void main(String argv[])
      {
	   try{
		   //Makes a Scanner that is used to read the input to the Scale.
		   	Scanner keyboard = new Scanner(System.in);
		   	
		   	//Makes a Socket with 169.254.2.2 as the IP and 8000 as Port.
		    Socket socketClient= new Socket("169.254.2.2",8000);
		    System.out.println("Client: "+"Connection Established");
 
		    //Makes a BufferedReader and Writer to write and read from the Socket.
		    BufferedReader reader = 
		    		new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
 
		    BufferedWriter writer= 
	        		new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
		    
		    
		    String scaleMessage;
		    System.out.println("Write your command below:");
		    
		    //Input  holds the value of the command you want to send to the scale.
		    String input = "";
		    
		    //stopMessage is the value you have to give input through the scanner to stop the continuous loop,
		    //that read, and writes to an from the scale.
		    String stopMessage = "Stop";
		    
		    //Continuous loop to write to the scale and receive an answer.
		    //Prints the message received from the scale.
		    while (!input.equals(stopMessage)) 
		    {
		    	System.out.println("Write a input on the keyboard:");
		    	input = keyboard.nextLine();
			    writer.write(input +"\r\n");
			    writer.flush();
				if((scaleMessage = reader.readLine()) != null)
				{
					//Prints out the answer received from the scale.
					System.out.println("Client: " + scaleMessage);
				}
			}
		    
 
	   }catch(Exception e){e.printStackTrace();}
      }
}