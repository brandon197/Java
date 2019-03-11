package eecs2030.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Abstract base class for simple word puzzles such as scrambled word puzzles
 * (where the puzzle word is made up of the letters of the original word in
 * random order). This class provides storage and access to the puzzle word.
 * Subclasses are responsible for providing storage and access to the solution
 * word or words.
 * 
 * 
 */
public abstract class AbstractWordPuzzle {
	/**
	 * The puzzle word.
	 */
	private String puzzle;

	/**
	 * Initializes this puzzle to the empty string.
	 */
	public AbstractWordPuzzle() {
		this("");

	}

	/**
	 * Initializes this puzzle to the specified puzzle word.
	 * 
	 * @param puzzleWord
	 *            the puzzle word
	 */
	public AbstractWordPuzzle(String puzzleWord) {
		this.puzzle = puzzleWord;

	}

	/**
	 * Get the solution word. For word puzzles with more than one solution this
	 * method returns the solution that comes first in dictionary order.
	 * 
	 * @return the solution word that comes first in dictionary order
	 */
	public abstract String getSolution();

	/**
	 * Get a sorted set of all of the solution words. {@code AbstractWordPuzzle}
	 * provides an implementation of this method that returns the set containing one
	 * string equal to the string returned by {@code this.getSolution()}. Subclasses
	 * should override this method if the word puzzle has multiple solutions.
	 * 
	 * <p>
	 * The set returned by this method cannot be used to modify the solutions for
	 * this puzzle.
	 * 
	 * @return a sorted set of solution words
	 */
	public SortedSet<String> getSolutions() {
		// COMPLETE THIS
		TreeSet<String> sol = new TreeSet<String>();
		sol.add(this.getSolution());
		return sol;
	}

	/**
	 * Get the puzzle word
	 * 
	 * @return the puzzle word
	 */
	public final String getPuzzleWord() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.puzzle;
	}

	/**
	 * Set the puzzle word for this puzzle.
	 * 
	 * @param puzzleWord
	 *            the puzzle word
	 */
	public final void setPuzzleWord(String puzzleWord) {
		// COMPLETE THIS
		this.puzzle = puzzleWord;

	}

	/**
	 * Get the string representation of the puzzle. The string is the puzzle word,
	 * followed by {@code " : "} followed by a comma separated list of solutions
	 * words.
	 * 
	 * @return the string representation of the puzzle
	 */
	public String toString() {
		// COMPLETE THIS
		SortedSet<String> ce = getSolutions();
		List<String> retu = new ArrayList<String>();
		if (ce.size() > 1) {
			
			for(String s: getSolutions()) {
			retu.add(s);
			
			}
			String re = this.puzzle + " : " + retu.toString();
			return re;
		}
		
		
		String re2 = this.puzzle + " : " + getSolution();
		return re2;
	}
}
