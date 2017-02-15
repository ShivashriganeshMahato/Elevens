/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Deck deck1 = new Deck(
				new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"},
				new String[] {"Spades", "Clubs", "Hearts", "Diamonds"},
				new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}
		);
		Deck deck2 = new Deck(
				new String[] {"Joker", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"},
				new String[] {"Spades", "Hearts"},
				new int[] {13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
		);
		Deck deck3 = new Deck(
				new String[] {"Jack", "Queen", "King", "Joker"},
				new String[] {"Circles"},
				new int[] {14, 15, 17, 2}
		);

		System.out.println("Deck 1:\n" + deck1.toString());
		System.out.println("Deck 2:\n" + deck2.toString());
		System.out.println("Deck 3:\n" + deck3.toString());

		System.out.println();

		System.out.println("Deck 1 is empty? " + deck1.isEmpty());
		System.out.println("Deck 2 is empty? " + deck2.isEmpty());
		System.out.println("Deck 3 is empty? " + deck3.isEmpty());

		System.out.println();

		System.out.println("Deck 1 size: " + deck1.size());
		System.out.println("Deck 2 size: " + deck2.size());
		System.out.println("Deck 3 size: " + deck3.size());

		System.out.println();

		System.out.println("Dealing Deck 1: " + deck1.deal().toString());
		System.out.println("Dealing Deck 2: " + deck2.deal().toString());
		System.out.println("Dealing Deck 3: " + deck3.deal().toString());

		System.out.println();

		System.out.println("Deck 1 size: " + deck1.size());
		System.out.println("Deck 2 size: " + deck2.size());
		System.out.println("Deck 3 size: " + deck3.size());

		System.out.println();

		System.out.println("Dealing all cards in Deck 1");
		while (deck1.size() > 0) System.out.println("\t" + deck1.deal().toString());
		System.out.println("Dealing all cards in Deck 2");
		while (deck2.size() > 0) System.out.println("\t" + deck2.deal().toString());
		System.out.println("Dealing all cards in Deck 3");
		while (deck3.size() > 0) System.out.println("\t" + deck3.deal().toString());

		System.out.println();

		System.out.println("Deck 1 is empty? " + deck1.isEmpty());
		System.out.println("Deck 2 is empty? " + deck2.isEmpty());
		System.out.println("Deck 3 is empty? " + deck3.isEmpty());

		System.out.println();

		System.out.println("Deck 1 size: " + deck1.size());
		System.out.println("Deck 2 size: " + deck2.size());
		System.out.println("Deck 3 size: " + deck3.size());

		System.out.println();

		System.out.println("Deck 1:\n" + deck1.toString());
		System.out.println("Deck 2:\n" + deck2.toString());
		System.out.println("Deck 3:\n" + deck3.toString());
	}
}
