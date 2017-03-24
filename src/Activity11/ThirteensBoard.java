package Activity11;

import Activity10.Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The ThirteensBoard class represents the board in a game of Thirteens.
 */
public class ThirteensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 10;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};


	/**
	 * Creates a new <code>ThirteenBoards</code> instance.
	 */
	 public ThirteensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Thirteen, the legal groups are (1) a pair of non-face cards
	 * whose values add to 13, and (2) a single king card
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		// If the size is 2, return whether there is a pair summing to 13. Else, return whether only one card is
		// selected and it is a king
		return selectedCards.size() == 2 ? !findPairSum13(selectedCards).isEmpty() : findKing(selectedCards).equals(-1);
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Thirteens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 13, or (2) a
	 * single kind card
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cIndexes = cardIndexes();
		return !findPairSum13(cIndexes).isEmpty() || findKing(cIndexes).equals(-1);
	}

	/**
	 * Look for an 13-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 13-pair.
	 * @return a list of the indexes of an 13-pair, if an 13-pair was found;
	 *         an empty list, if an 13-pair was not found.
	 */
	private List<Integer> findPairSum13(List<Integer> selectedCards) {
		List<Integer> pairIndexes = new ArrayList<>();

		for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
			int k1 = selectedCards.get(sk1).intValue();
			for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
				int k2 = selectedCards.get(sk2).intValue();
				if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 13) {
					pairIndexes.add(k1);
					pairIndexes.add(k2);
					return pairIndexes;
				}
			}
		}

		return pairIndexes;
	}

	/**
	 * Looks for a king in the selected cards (should be 1).
	 * @param selectedCards selects a subset of this board.  It should be a
	 *                      single index in this board that is searched to
	 *                      find a king.
	 * @return the index of the king if the card is a king,
	 * 		   -1 if not
	 */
	private Integer findKing(List<Integer> selectedCards) {
		// Make sure only 1 card is selected and check if the selected card is a king
		if (selectedCards.size() == 1 && cardAt(selectedCards.get(0)).rank().equals("king"))
			return selectedCards.get(0);
		return -1;
	}

	/**
	 * Looks for a legal play on the board.  If one is found, it plays it.
	 * @return true if a legal play was found (and made); false othewise.
	 */
	public boolean playIfPossible() {
		if (anotherPlayIsPossible())
			return playPairSum13IfPossible() || playKIfPossible();
		return false;
	}

	/**
	 * Looks for a pair of non-face cards whose values sum to 13.
	 * If found, replace them with the next two cards in the deck.
	 * The simulation of this game uses this method.
	 * @return true if an 13-pair play was found (and made); false othewise.
	 */
	private boolean playPairSum13IfPossible() {
		List<Integer> pairIndexes = findPairSum13(cardIndexes());
		replaceSelectedCards(pairIndexes);

		return pairIndexes.size() == 2;
	}

	/**
	 * Looks for a king.
	 * If found, replace it with the next card in the deck.
	 * The simulation of this game uses this method.
	 * @return true if a king play was found (and made); false otherwise.
	 */
	private boolean playKIfPossible() {
		Integer kingIndex = findKing(cardIndexes());
		if (!kingIndex.equals(-1)) {
			replaceSelectedCards(Collections.singletonList(kingIndex));
			return true;
		}
		return false;
	}
}
