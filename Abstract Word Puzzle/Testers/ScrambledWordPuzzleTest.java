package eecs2030.lab5;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScrambledWordPuzzleTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	private Map<Character, Integer> countLetters(String word) {
		Map<Character, Integer> m = new HashMap<>();
		for (Character c : word.toCharArray()) {
			if (m.containsKey(c)) {
				Integer count = m.get(c);
				m.put(c, count + 1);
			}
			else {
				m.put(c, 1);
			}
		}
		return m;
	}
	
	@Test
	public void test01a_ctor() {
		AbstractWordPuzzle p = new ScrambledWordPuzzle("shuffle");
		Map<Character, Integer> exp = countLetters("shuffle");
		Map<Character, Integer> got = countLetters(p.getPuzzleWord());
		assertEquals("ctor did not set this.puzzle correctly", exp,
						got);
	}
	
	@Test
	public void test01b_ctor() {
		AbstractWordPuzzle p = new ScrambledWordPuzzle("SCRAMBLE");
		Map<Character, Integer> exp = countLetters("SCRAMBLE");
		Map<Character, Integer> got = countLetters(p.getPuzzleWord());
		assertEquals("ctor did not set this.puzzle correctly", exp,
						got);
	}
	
	@Test
	public void test01c_ctor() {
		AbstractWordPuzzle p = new ScrambledWordPuzzle("shuffle");
		assertNotEquals("ctor probably did not set this.puzzle correctly", "shuffle",
						p.getPuzzleWord());
	}
	
	@Test
	public void test01d_ctor() {
		AbstractWordPuzzle p = new ScrambledWordPuzzle("SCRAMBLE");
		assertNotEquals("ctor probably did not set this.puzzle correctly", "SCRAMBLE",
						p.getPuzzleWord());
	}

	@Test
	public void test02a_getSolution() {
		AbstractWordPuzzle p = new ScrambledWordPuzzle("shuffle");
		assertEquals("getSolution() returned the wrong string", "shuffle",
						p.getSolution());
	}
	
	@Test
	public void test02b_getSolution() {
		AbstractWordPuzzle p = new ScrambledWordPuzzle("BYE");
		assertEquals("getSolution() returned the wrong string", "BYE",
						p.getSolution());
	}
}
