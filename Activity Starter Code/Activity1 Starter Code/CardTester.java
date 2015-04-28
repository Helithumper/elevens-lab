import java.util.ArrayList;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Eight","Spades",8));
		cards.add(new Card("Nine","Hearts",9));
		cards.add(new Card("Eight","Spades",8));
		
		Card matchTest = new Card("Nine","Hearts",9);
		
		System.out.println("TESTING!");
		for(Card c:cards){
			System.out.println("###########################\n"+c.toString());
			System.out.println("Rank: " + c.rank());
			System.out.println("Suit: " + c.suit());
			System.out.println("Value: " + c.pointValue());
			System.out.println("Is Same As Test Card? " + c.matches(matchTest));
		}
	}
}
