AbstractWordPuzzle

The abstract class AbstractWordPuzzle is the superclass for simple word puzzles such as scrambled word puzzles 
(where the puzzle word is made up of the letters of the original word in random order). 
This class provides storage and access to the puzzle word. The puzzle word is the word presented to the player that needs to be solved; 
for example, a scrambled word puzzle might have the puzzle word zelzup corresponding to the solution puzzle. Subclasses are responsible 
for providing storage and access to the solution word or words.

ScrambledWordPuzzle

A ScrambledWordPuzzle is a word puzzle where the puzzle word is formed by randomly shuffling the letters of the solution word. 
Many scrambled word puzzles have multiple solutions but this class assumes that there is only one solution for the puzzle.

ReverseWordPuzzle

A ReverseWordPuzzle is a word puzzle where the puzzle word is formed by taking the letters of the solution word 
in reverse order. For example the puzzle word elzzup has the solution puzzle.

MissingVowelsPuzzle

A word puzzle where the letters 'a', 'e', 'i', 'o', and 'u' are missing from the puzzle word and replaced with an 
underscore '_'. For example:

MissingVowelsPuzzle p = new MissingVowelsPuzzle("facetious"); 
System.out.println(p);

outputs: f_c_t___s : facetiou
