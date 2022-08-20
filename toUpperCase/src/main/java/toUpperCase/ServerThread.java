package toUpperCase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

	private ServerMain serverMain;
	private Socket socket;

	public ServerThread(Socket socket, ServerMain serverMain) {
		this.socket = socket;
		this.serverMain = serverMain;
	}

	@Override
	public void run() {
		try {
			int clientNumber = serverMain.getClientNumber();
			System.out.println("Client " + clientNumber + " has connected.");

			// I/O buffers
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			// Solution
			String message = ""; // Initial value for the message so we can enter the while loop
			while (!(message.equalsIgnoreCase("exit"))) { // test if message is equal to exit to quit the game
				message = in_socket.readLine(); // get the text written by the client
				out_socket.println(message + ".toUpperCase() is : " + message.toUpperCase()); // output the result to
																								// the client
			}

			// this line will be reached when the game is exited
			socket.close(); // close the socket when the game is exited
			System.out.println("Client " + clientNumber + " has disconnected.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
