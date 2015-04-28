
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *
	 * @param args
	 *            is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
		String[] suits = { "Diamonds", "Clubs", "Spades", "Hearts" };
		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		Deck d1 = new Deck(ranks, suits, values);
		Deck d2 = new Deck(ranks, suits, values);
		Deck d3 = new Deck(ranks, suits, values);
		System.out.println(d1.deal() + "\n" + d2.deal() + "\n" + d3.deal());
	}
}

/*Questions
 * 1. A Deck Has Cards
 * 2. Three
 * 3. Ranks has Two through Ace ; Suits has all four suits ; values has the values 2,3,4,5,6,7,8,9,10,10,10,10,11
 * 4. No, because the deck is immediately shuffled
 */
 
