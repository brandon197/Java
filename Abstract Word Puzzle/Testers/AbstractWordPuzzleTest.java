package eecs2030.lab5;

import static org.junit.Assert.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AbstractWordPuzzleTest {
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	private static class SimplePuzzle extends AbstractWordPuzzle {
		private String solution;
		
		SimplePuzzle() {
			super("");
			this.solution = "";
		}
		
		SimplePuzzle(String puzzleWord) {
			super(puzzleWord.toUpperCase());
			this.solution = puzzleWord.toLowerCase();
		}

		@Override
		public String getSolution() {
			return this.solution;
		}
	}
	
	@Test
	public void test01_noArgCtor() {
		AbstractWordPuzzle p = new SimplePuzzle();
		assertEquals("no arg ctor did not set this.puzzle correctly", "",
						p.getPuzzleWord());
	}
	
	@Test
	public void test02a_ctor() {
		AbstractWordPuzzle p = new SimplePuzzle("HI");
		assertEquals("ctor did not set this.puzzle correctly", "HI",
						p.getPuzzleWord());
	}
	
	@Test
	public void test02b_ctor() {
		AbstractWordPuzzle p = new SimplePuzzle("BYE");
		assertEquals("ctor did not set this.puzzle correctly", "BYE",
						p.getPuzzleWord());
	}
	
	@Test
	public void test03a_getSolutions() {
		AbstractWordPuzzle p = new SimplePuzzle("HI");
		SortedSet<String> got = p.getSolutions();
		SortedSet<String> exp = new TreeSet<>();
		exp.add("hi");
		assertEquals("ctor did not set this.puzzle correctly", exp,
						got);
	}
	
	@Test
	public void test04a_getPuzzleWord() {
		AbstractWordPuzzle p = new SimplePuzzle("HI");
		p.setPuzzleWord("Hi");
		assertEquals("setPuzzleWord did not set this.puzzle correctly", "Hi",
						p.getPuzzleWord());
	}
	
	@Test
	public void test04b_getPuzzleWord() {
		AbstractWordPuzzle p = new SimplePuzzle("BYE");
		p.setPuzzleWord("ByE");
		assertEquals("setPuzzleWord did not set this.puzzle correctly", "ByE",
						p.getPuzzleWord());
	}
	
	@Test
	public void test05a_toString() {
		AbstractWordPuzzle p = new SimplePuzzle("HI");
		assertEquals("toString did not return the correct string", "HI : hi",
						p.toString());
	}
	
	@Test
	public void test05b_toString() {
		AbstractWordPuzzle p = new SimplePuzzle("BYE");
		assertEquals("toString did not return the correct string", "BYE : bye",
						p.toString());
	}
}
