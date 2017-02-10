/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card1 = new Card("King", "Spades", 13);
		Card card2 = new Card("Jack", "Hearts", 11);
		Card card3 = new Card("King", "Spades", 13);

        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());

        System.out.println();

        System.out.println("Card 1 equals card 2? " + card1.matches(card2));
        System.out.println("Card 2 equals card 3? " + card2.matches(card3));
        System.out.println("Card 3 equals card 1? " + card3.matches(card1));
    }
}
