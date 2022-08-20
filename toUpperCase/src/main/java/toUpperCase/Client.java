package toUpperCase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
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

		while (!message.equalsIgnoreCase("EXIT")) {// test if message is equal to exit to quit the game
			System.out.print("  Enter your text:   ");
			message = keyboard.nextLine();// read user's input and store it to String "message"
			out_socket.println(message);// send user's input to the server
			message = in_socket.readLine(); // receive server's response
			System.out.println(message);// print server's response in console
		}

		socket.close();
		System.out.println("Socket closed. ");
	}

	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
