package eecs2030.lab5;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReverseWordPuzzleTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	@Test
	public void test01a_ctor() {
		AbstractWordPuzzle p = new ReverseWordPuzzle("ih");
		assertEquals("ctor did not set this.puzzle correctly", "ih",
						p.getPuzzleWord());
	}
	
	@Test
	public void test01b_ctor() {
		AbstractWordPuzzle p = new ReverseWordPuzzle("EYB");
		assertEquals("ctor did not set this.puzzle correctly", "EYB",
						p.getPuzzleWord());
	}
	
	@Test
	public void test02a_getSolution() {
		AbstractWordPuzzle p = new ReverseWordPuzzle("ih");
		assertEquals("getSolution() returned the wrong string", "hi",
						p.getSolution());
	}
	
	@Test
	public void test02b_getSolution() {
		AbstractWordPuzzle p = new ReverseWordPuzzle("EYB");
		assertEquals("getSolution() returned the wrong string", "BYE",
						p.getSolution());
	}

}
