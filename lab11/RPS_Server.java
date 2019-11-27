import java.net.*;
import java.io.*;

public class RPS_Server {
	// if move1 wins against move2
	public static boolean win(String move, String enemy) {
		if ((move.equals("r") && enemy.equals("s"))
		|| (move.equals("s") && enemy.equals("p"))
		|| (move.equals("p") && enemy.equals("r"))
		) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		int port = Integer.parseInt(args[0]);
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server started at port " + port + "\n");

		Socket player1 = null;
		Socket player2 = null;
		BufferedReader in1 = null;
		BufferedReader in2 = null;
		PrintWriter out1 = null;
		PrintWriter out2 = null;

		try {
			player1 = serverSocket.accept();
			in1 = new BufferedReader(new InputStreamReader(player1.getInputStream()));
			out1 = new PrintWriter(player1.getOutputStream(), true);

			player2 = serverSocket.accept();
			in2 = new BufferedReader(new InputStreamReader(player2.getInputStream()));
			out2 = new PrintWriter(player2.getOutputStream(), true);
		}
		catch (UnknownHostException u) {
			System.out.println(u);
		}
		catch (IOException i) {
			System.out.println(i);
		}

		String move1;
		String move2;
		int score1 = 0;
		int score2 = 0;

		while (true) {
			try {
				move1 = in1.readLine().toLowerCase();
				move2 = in2.readLine().toLowerCase();

				if (win(move1, move2)) {
					score1++;
				}
				if (win(move2, move1)) {
					score2++;
				}
				out1.println(score1);
				out1.println(score2);

				out2.println(score2);
				out2.println(score1);

				if (score1 == 10 || score2 == 10) {
					break;
				}
			}
			catch (IOException i) {
				System.out.println(i);
			}
		}

		System.out.println("Closing connection.");

		try {
			in1.close();
			out1.close();
			player1.close();

			in2.close();
			out2.close();
			player2.close();

			serverSocket.close();
		}
		catch (IOException i) {
			System.out.println(i);
		}
	}
}