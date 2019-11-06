import java.util.Scanner;

public class pa1b {
	public static void main (String args[]) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		while (N-->0) {
			int width = scanner.nextInt(), copies = scanner.nextInt(), space = scanner.nextInt(), height = (width + 1) / 2;
			for (int y = 0; y < height; y++) {
				for (int i = 0; i < copies; i++) {
					for (int x = 0; x < width; x++) {
						if (y == height - 1 || x == height - y - 1 || x == height + y - 1) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					if (copies > 1) {
					    while (space-->0) {
						    System.out.print(" ");
					    }
					}
				}
				System.out.println();
			}
		}
	}
}