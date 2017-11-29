import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

/**
 * Testing index functionalities
 * @author Lam Ngo
 * @version 06/02/2016
 * 
  * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class IndexTests {

    private Index index;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before
    public void setUp() throws Exception {
        index = new Index();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        index = null;
        System.setOut(null);
    }
    
    @Test
    public void testPrintIndex() {
        index.createIndexFromFile("data/micro-input.txt");
        String expected = "INDEX:\n"
                          + "======\n"
                          + "and: 2, 4\n"
                          + "another: 3, 4\n"
                          + "final: 5\n"
                          + "more: 2\n"
                          + "new: 2\n"
                          + "some: 1\n"
                          + "the: 5\n"
                          + "this: 1, 2\n"
                          + "with: 1, 2, 5\n"
                          + "words: 1, 2, 5\n"
                          + "yet: 4";        
        index.printIndex();
        assertEquals("Printing the index should look as follows.", expected, outContent.toString().trim());
    }
    
    @Test
    public void testPrintExcludedWords() {
        index.createIndexFromFile("data/micro-input.txt");
        String expected = "DICTIONARY of excluded words:\n"
                          + "=============================\n"
                          + "page";        
        index.printExcludedWords();
        assertEquals("Printing the dictionary of excluded words should look as follows.", expected, outContent.toString().trim());
    }
    
    @Test
    public void testTextWithLotsOfPunctuation(){
    	index.createIndexFromFile("data/lotsofpunc.txt");
    	String expected = "INDEX:\n"
    					+	"======\n"
    					+	"cat: 4, 5\n"
    					+	"dog: 1, 2\n"
    					+	"elephant: 4\n"
    					+	"giraffe: 4\n"
    					+	"mouse: 3, 4, 5, 6\n"
    					+	"rabbit: 6\n"
    					+	"sloth: 4\n"
    					+	"squirrel: 4\n"
    					+	"turtle: 5";
    	index.printIndex();
    	assertEquals("Printing the index should look like this", expected,outContent.toString().trim());
    }
    
    @Test
    public void testTextWithsamelinesanduppercase(){
       	index.createIndexFromFile("data/sameline.txt");
    	String expected = "INDEX:\n"
    					+	"======\n"
    					+	"affair: 1, 2, 3, 4\n"
    					+	"book: 1, 2, 3, 4\n"
    					+	"finished: 1, 2, 3, 4\n"
    					+	"half: 1, 2, 3, 4\n"
    					+	"like: 1, 2, 3, 4\n"
    					+	"love: 1, 2, 3, 4";
    	index.printIndex();
    	assertEquals("Printing the index should look like this", expected,outContent.toString().trim());
    }
    
    @Test
    public void testSplitEvenIndex(){
    	index.createIndexFromFile("data/TEST2.txt");
    	String expected = "INDEX:\n"
				+	"======\n"
				+	"doo: 1, 2, 3, 4\n"
				+	"dooo: 1, 2, 3, 4\n"
				+	"not: 1, 2, 3, 4\n"
				+	"oor: 1, 2, 3, 4";
    	index.printIndex();
    	assertEquals("Printing the index should look like this", expected,outContent.toString().trim());
    }
    
    @Test
    public void testSplitEvenDictionary(){
         index.createIndexFromFile("data/TEST2.txt");
         String expected = "DICTIONARY of excluded words:\n"
                              + "=============================\n"
                              + "iss\n"
                              + "noo\n"
                              + "there\n"
                              + "try";        
         index.printExcludedWords();
         assertEquals("Printing the dictionary of excluded words should look as follows.", expected, outContent.toString().trim());
   }
    
    @Test
    public void testRandomTextfrominternet(){
       	index.createIndexFromFile("data/Test.txt");
    	String expected = "INDEX:\n"
    					+	"======\n"
    					+	"all: 2\n"
    					+	"ancestor: 3\n"
    					+	"ancient: 4\n"
    					+	"author: 3\n"
    					+	"b.c: 2\n"
    					+	"back: 2\n"
    					+	"being: 3\n"
    					+	"century: 2\n"
    					+	"character: 1\n"
    					+	"diple: 4\n"
    					+	"earliest: 3\n"
    					+	"evolution: 4\n"
    					+	"extends: 2\n"
    					+	"family: 2\n"
    					+	"from: 4\n"
    					+	"houston: 3\n"
    					+	"into: 3\n"
    					+	"its: 2, 3\n"
    					+	"mark: 1\n"
    					+	"punctuation: 1\n"
    					+	"second: 2\n"
    					+	"sprang: 3\n"
    					+	"storied: 1\n"
    					+	"texts: 4\n"
    					+	"the: 1, 2, 4\n"
    					+	"tree: 2\n"
    					+	"way: 2\n"
    					+	"when: 3";
    					
    	index.printIndex();
    	assertEquals("Printing the index should look like this", expected,outContent.toString().trim());
    }
    
    @Test
    public void testRandomTextfrominternet2(){
        index.createIndexFromFile("data/Test.txt");
        String expected = "DICTIONARY of excluded words:\n"
                          + "=============================";       
        index.printExcludedWords();
        assertEquals("Printing the dictionary of excluded words should look as follows.", expected, outContent.toString().trim());
    }
    
    @Test
    public void testRepeatedtwicewords(){
        index.createIndexFromFile("data/anotherinput.txt");
        String expected = "could: 4, 5\n";
        index.printIndex();
        assertThat(outContent.toString(), containsString(expected));
    }
    
    @Test
    public void testRepeatedtwicewords2(){
        index.createIndexFromFile("data/anotherinput.txt");
        String expected = "and: 2, 6\n";
        index.printIndex();
        assertThat(outContent.toString(), containsString(expected));
    }
    
    @Test
    public void testRepeatedthricewords(){
        index.createIndexFromFile("data/anotherinput.txt");
        String expected = "garden: 1, 3, 5\n";
        index.printIndex();
        assertThat(outContent.toString(), containsString(expected));
    }
    
    @Test
    public void testRepeatedthricewords2(){
        index.createIndexFromFile("data/anotherinput.txt");
        String expected = "made: 5, 6, 7\n";
        index.printIndex();
        assertThat(outContent.toString().trim(),containsString(expected));
    }
    
    @Test
    public void test1worddictionary(){
        index.createIndexFromFile("data/anotherinput.txt");
        String expected = "DICTIONARY of excluded words:\n"
                + "=============================\n"
        		+"the"; 
        index.printExcludedWords();
        assertEquals("Dictionary should look like this", expected, outContent.toString().trim());
    }
    
    @Test
    public void testEmptyIndex(){
       	index.createIndexFromFile("data/allsameword.txt");
    	String expected = "INDEX:\n"
    					+	"======";
    	index.printIndex();
    	assertEquals("Printing the index should look like this", expected,outContent.toString().trim());
    }
    
    @Test
    public void testAllgotodictionary(){
       	index.createIndexFromFile("data/allsameword.txt");
    	String expected = "DICTIONARY of excluded words:\n"
    					+	"=============================\n"
    					+	"all\n"
    					+	"same\n"
    					+	"word\n";
    	index.printExcludedWords();
    	assertEquals("Printing the index should look like this", expected,outContent.toString());
    }
}
