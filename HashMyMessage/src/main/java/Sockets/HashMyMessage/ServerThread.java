package Sockets.HashMyMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;

public class ServerThread implements Runnable {

	private ServerMain serverMain;
	private Socket socket;

	public ServerThread(Socket socket, ServerMain serverMain) {
		this.socket = socket;
		this.serverMain = serverMain;
	}

	public void run() {
		try {
			int clientNumber = serverMain.getClientNumber();
			System.out.println("Client " + clientNumber + " has connected.");

			// I/O buffers:
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			String message = ""; // Initial value for the message so we can enter the while loop
			String hashed = ""; // Initial value for the hashed message
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

			while (!(message.equalsIgnoreCase("exit"))) { // test if message is equal to exit to quit the game
				message = in_socket.readLine(); // read the newest message from the socket

				messageDigest.update(message.getBytes()); // get the text written by the client
				BigInteger bigInt = new BigInteger(1, messageDigest.digest());
				hashed = bigInt.toString(16);
				out_socket.println(" '" + message + "' hashed is : " + hashed);
			}

			// this line will be reached when the game is exited
			socket.close(); // close the socket when the game is exited
			System.out.println("Client " + clientNumber + " has disconnected.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
