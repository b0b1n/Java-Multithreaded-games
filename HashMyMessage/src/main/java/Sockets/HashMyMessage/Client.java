package Sockets.HashMyMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
	public Client() throws Exception {

		Socket socket = new Socket("127.0.0.1", 2022);
		System.out.println("Succefully connected to the server.");

		// I/O
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		Scanner keyboard = new Scanner(System.in);
		String message = "";// Initial value for the message so we can enter the while loop
		System.out.println(
				"\t \t -------------------------- \n\t \t || To quit, type 'Exit' ||\n\t \t -------------------------- ");

		String[] mustNotEqual = { "CON", "PRN", "AUX", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7",
				"COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9" };
		
		char[] mustNotContain = {'}','{', '&','#','%','<', '>', ':', '"', '/', '\\', '|', '?', '*' };

		while (!message.equalsIgnoreCase("EXIT")) {// test if message is equal to exit to quit the game
			System.out.print("  Enter your text:   ");
			message = keyboard.nextLine();// read user's input and store it to String "message"

			/*
			 * If you execute this command you will get the hashed message in the Terminal
			 * But unfortunately it won't be displayed correctly
			 * System.out.println(message);// print server's response in console
			 */

			/// Create a file that will contain the hashed message
			PrintWriter myWriter;
			if(Arrays.asList(mustNotEqual).contains(message) || hasAnyCaracters(message, mustNotContain)){
				myWriter = new PrintWriter("hashed messages/__" + message + "__hashed.txt", "UTF-16");				
			}else {				
				myWriter = new PrintWriter("hashed messages/__" + message + "__hashed.txt", "UTF-16");
			}
			out_socket.println(message);// send user's input to the server
			message = in_socket.readLine(); // receive server's response

			/*
			 * Write in the file the message from the server that contains the hashed
			 * message
			 */
			myWriter.println(message);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		}

		socket.close();
		System.out.println("Socket closed.");

	}

	private boolean hasAnyCaracters(String message, char[] sequence) {
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < sequence.length; j++) {
				if (message.charAt(i) == sequence[j])
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
