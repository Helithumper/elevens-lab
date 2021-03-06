import java.util.Arrays;
import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call to
	 * each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 20;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 5;

	/**
	 * Tests shuffling methods.
	 * 
	 * @param args
	 *            is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT
				+ " consecutive perfect shuffles:");
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++) {
			values1[i] = i;
		}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT
				+ " consecutive efficient selection shuffles:");
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
			values2[i] = i;
		}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values2 = selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Apply a "perfect shuffle" to the argument. The perfect shuffle algorithm
	 * splits the deck in half, then interleaves the cards in one half with the
	 * cards in the other.
	 * 
	 * @param values
	 *            is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int max = (values.length+1)/2;
		int[] shuffled = new int[values.length];
		int k = 0;
		for (int j = 0; j < (values.length); j++) {
			shuffled[k] = values[j];
			k++;
		}
		k = 0;
		for (int j = 0; j < max; j++) {
			values[k] = shuffled[j];
			k += 2;
		}
		k=1;
		for (int j = max+1; j < values.length; j++){
			values[k] = shuffled[j];
			k+=2;
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument. The selection
	 * shuffle algorithm conceptually maintains two sequences of cards: the
	 * selected cards (initially empty) and the not-yet-selected cards
	 * (initially the entire deck). It repeatedly does the following until all
	 * cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards. An efficient version of this
	 * algorithm makes use of arrays to avoid searching for an as-yet-unselected
	 * card.
	 * 
	 * @param values
	 *            is an array of integers simulating cards to be shuffled.
	 */
	public static int[] selectionShuffle(int[] values) {
		Random rand = new Random();
		for (int k = values.length - 1; k > 0; k--) {
			int r = rand.nextInt((k) + 1);
			int transfer = values[k];
			values[k] = values[r];
			values[r] = transfer;
		}
		return values;
	}

	
}

/*
 * Questions: 
 * 
 * 1. public static String flip(){ Random rand = new Random(); String
 * result = (rand.nextInt((3)+1)==1) ? "tails" : "heads"; return result; }
 * 
 * 2.public static Boolean arePermutations(int[] a, int[] b) {
		for (int i = 0; i < a.length - 1; i++) { // For each element in the
			// array
			int smallestIndex = i; // Assume that the first value is the
			// smallest
			for (int j = i + 1; j < a.length; j++) { // For every value
				// after i...
				if (a[smallestIndex] > a[j]) { // If the item at j is
					// smaller than at i
					smallestIndex = j; // J is the smallest number
				}

			}
			swap(a, smallestIndex, i);
		}
		
		for (int i = 0; i < b.length - 1; i++) { // For each element in the
			// array
			int smallestIndex = i; // Assume that the first value is the
			// smallest
			for (int j = i + 1; j < b.length; j++) { // For every value
				// after i...
				if (b[smallestIndex] > b[j]) { // If the item at j is
					// smaller than at i
					smallestIndex = j; // J is the smallest number
				}

			}
			swap(b, smallestIndex, i);
		}
		
		return Arrays.toString(a)==Arrays.toString(b);
	}
	static void swap(int[] array, int a, int b) {
		if (a >= array.length || b >= array.length) {
			return;
		}
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	3. 3, 2
 */
