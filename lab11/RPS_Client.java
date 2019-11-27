import java.net.*;
import java.io.*;

public class RPS_Client {
	public static void main(String[] args) throws Exception {
		String address = args[0];
		int port = Integer.parseInt(args[1]);
		Socket socket = null;
		BufferedReader clientIn = null;
		BufferedReader socketIn = null;
		PrintWriter socketOut = null;
		try {
			socket = new Socket(address, port);
			clientIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketOut = new PrintWriter(socket.getOutputStream(), true);
		}
		catch (UnknownHostException u) {
			System.out.println(u);
		}
		catch (IOException i) {
			System.out.println(i);
		}

		String move;
		int myScore;
		int opScore;

		while (true) {
			try {
				move = clientIn.readLine();
				socketOut.println(move);

				myScore = Integer.parseInt(socketIn.readLine());
				opScore = Integer.parseInt(socketIn.readLine());

				System.out.println("You: " + myScore + " pts");
				System.out.println("Opponent: " + opScore + " pts");

				if (myScore == 10 || opScore == 10) {
					System.out.println("I " + (myScore == 10 ? "win!" : "lose."));
					break;
				}
			}
			catch(IOException i) {
				System.out.println(i);
			}
		}

		try {
			clientIn.close();
			socketIn.close();
			socketOut.close();
			socket.close();
		}
		catch(IOException i) {
			System.out.println(i);
		}
	}
}