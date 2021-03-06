import java.util.Scanner;

public class Nim {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Generate a random number between 0 and 100
		int sizeOfPile = (int) (Math.random() * 91) + 10;

		// Generate a random number between 0 and 1
		// 0 is computer turn, 1 is human turn
		int currentTurn = (int) (Math.random() * 2);
		System.out.println((currentTurn == 0 ? "Computer goes first" : "You go first"));

		// 0 means computer is smart, 1 is stupid
		int smartOrStupid = (int) (Math.random() * 2);
		System.out.println((currentTurn == 0 ? "Computer will be smart" : "Computer will be stupid"));

		while (sizeOfPile > 0) {
			System.out.println("Current number of marbles in pile: " + sizeOfPile);

			int marblesToRemove = 0;
			if (currentTurn == 0) {
				// Computer's turn if it's stupid or size of pile is a power of 2 minus one, make a random move
				if (smartOrStupid == 1
						|| (sizeOfPile == 1 || sizeOfPile == 3 || sizeOfPile == 7 || sizeOfPile == 15
								|| sizeOfPile == 31 || sizeOfPile == 63)) {
					// Generate a number between 1 and half the pile
					marblesToRemove = (int) (Math.random() * (sizeOfPile / 2 + 1)) + 1;
				} else {
					// Play smartly, since we know the pile is limited to 100, we can hardcode the limits
					if (sizeOfPile > 63) {
						marblesToRemove = sizeOfPile - 63;
					} else if (sizeOfPile > 31) {
						marblesToRemove = sizeOfPile - 31;
					} else if (sizeOfPile > 15) {
						marblesToRemove = sizeOfPile - 15;
					} else if (sizeOfPile > 7) {
						marblesToRemove = sizeOfPile - 7;
					} else if (sizeOfPile > 3) {
						marblesToRemove = sizeOfPile - 3;
					} else {
						marblesToRemove = sizeOfPile - 1;
					}
				}
				if (marblesToRemove > sizeOfPile / 2)
					marblesToRemove--;
				System.out.println("Computer removes " + marblesToRemove + " marble(s).");
				currentTurn = 1; // human's turn next
			} else {
				// Human turn
				do {
					System.out.println("How many marbles do you want to remove: ");
					marblesToRemove = in.nextInt();
				} while ((marblesToRemove != 1) && (marblesToRemove <= 0 || marblesToRemove > sizeOfPile / 2));
				currentTurn = 0; // computer's turn next
			}

			sizeOfPile -= marblesToRemove;
		}
		if (currentTurn == 0) {
			// Means human took last turn
			System.out.println("Human took last marble, human looses.");
		} else {
			System.out.println("Computer took last marble, computer looses.");
		}
	}
}