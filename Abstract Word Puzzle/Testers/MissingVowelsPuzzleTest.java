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
public class MissingVowelsPuzzleTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	@Test
	public void test01a_ctor() {
		AbstractWordPuzzle p = new MissingVowelsPuzzle("Saturday");
		assertEquals("ctor did not set this.puzzle correctly", "S_t_rd_y",
						p.getPuzzleWord());
	}

	@Test
	public void test01b_ctor() {
		AbstractWordPuzzle p = new MissingVowelsPuzzle("November");
		assertEquals("ctor did not set this.puzzle correctly", "N_v_mb_r",
						p.getPuzzleWord());
	}
	
	@Test
	public void test02a_ctor() {
		String[] other = {"cot", "cut"};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("cat", other);
		assertEquals("ctor did not set this.puzzle correctly", "c_t",
						p.getPuzzleWord());
	}

	@Test
	public void test02b_ctor() {
		String[] other = {"cat", "cut"};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("cot", other);
		assertEquals("ctor did not set this.puzzle correctly", "c_t",
						p.getPuzzleWord());
	}
	
	@Test
	public void test02c_ctor() {
		String[] other = {"door", "dour", "deer", "doer"};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("dear", other);
		assertEquals("ctor did not set this.puzzle correctly", "d__r",
						p.getPuzzleWord());
	}

	
	@Test
	public void test02d_ctor() {
		String[] other = {"out", "oat"};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("eat", other);
		assertEquals("ctor did not set this.puzzle correctly", "__t",
						p.getPuzzleWord());
	}
	
	@Test
	public void test02e_ctorThrows() {
		String[] other = {"out", "oat", "cat"};
		try {
			new MissingVowelsPuzzle("eat", other);
			fail("ctor failed to throw an exception: cat is a not a solution for __t");
		}
		catch (IllegalArgumentException x) {
			// ok
		}
		catch (Exception x) {
			fail("ctor threw the wrong type of exception");
		}
	}
	
	@Test
	public void test03a_getSolution() {
		String[] other = {"door", "dour", "deer", "doer"};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("dear", other);
		assertEquals("getSolution() returned the wrong string", "dear",
						p.getSolution());
	}
	
	@Test
	public void test04a_getSolutions() {
		String[] other = {"door", "dour", "deer", "doer"};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("dear", other);
		SortedSet<String> exp = new TreeSet<>();
		exp.add("dear");
		for (String s : other) {
			exp.add(s);
		}
		SortedSet<String> got = p.getSolutions();
		assertEquals("getSolutions() returned the wrong set", exp,
						got);
	}
	
	@Test
	public void test04b_getSolutions() {
		String[] other = {};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("Saturday", other);
		SortedSet<String> exp = new TreeSet<>();
		exp.add("Saturday");
		for (String s : other) {
			exp.add(s);
		}
		SortedSet<String> got = p.getSolutions();
		assertEquals("getSolutions() returned the wrong set", exp,
						got);
	}
	
	@Test
	public void test04c_getSolutions() {
		String[] other = {"out", "oat"};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("eat", other);
		SortedSet<String> exp = new TreeSet<>();
		exp.add("eat");
		for (String s : other) {
			exp.add(s);
		}
		SortedSet<String> got = p.getSolutions();
		assertEquals("getSolutions() returned the wrong set", exp,
						got);
	}
	
	@Test
	public void test05a_toString() {
		String[] other = {"door", "dour", "deer", "doer"};
		AbstractWordPuzzle p = new MissingVowelsPuzzle("dear", other);
		String exp = "d__r : dear, deer, doer, door, dour";
		assertEquals("toString() returned the wrong string for a puzzle with multiple solutions", 
				exp, p.toString());
	}
}
