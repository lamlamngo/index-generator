import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing IndexNode functionalities
 * @author Lam Ngo
 * @version 06/02/2016
 * 
  * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class IndexNodeTests {
    private IndexNode index;
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        index = null;
    }
    
    @Test
    public void testCreate(){
    	index = new IndexNode("Lam");
    	String expected = "Lam:";
    	assertEquals("Index tostring should look like this", expected, index.toString());
    }
    
    @Test
    public void testinsertPage1(){
    	index = new IndexNode("Lam");
    	index.insert(1);
    	String expected = "Lam: 1";
    	assertEquals("Index tostring should look like this", expected, index.toString());
    }
    
    @Test
    public void testinsertPage2(){
    	index = new IndexNode("Lam");
    	index.insert(1);
    	index.insert(2);
    	String expected = "Lam: 1, 2";
    	assertEquals("Index tostring should look like this", expected, index.toString());
    }
    
    @Test
    public void testifFull(){
    	index = new IndexNode("Lam");
    	index.insert(1);
    	index.insert(2);
    	index.insert(3);
    	assertEquals("IndexNode should not be full (only 3 pages held)", false, index.ifFull());
    }
    
    @Test
    public void testifFull2(){
    	index = new IndexNode("Lam");
    	index.insert(1);
    	index.insert(2);
    	index.insert(3);
    	index.insert(7);
    	assertEquals("IndexNode should be full (4 pages held)", true, index.ifFull());
    }
    
    @Test
    public void testifAlreadyin1(){
    	index = new IndexNode("Lam");
    	index.insert(1);
    	index.insert(2);
    	index.insert(3);
    	assertEquals("IndexNode should hold page 2", true, index.ifAlreadyin(2));
    }
    
    @Test
    public void testifAlreadyin2(){
    	index = new IndexNode("Lam");
    	index.insert(1);
    	index.insert(2);
    	index.insert(3);
    	assertEquals("IndexNode should not hold page 4", false, index.ifAlreadyin(4));
    }
    
    @Test
    public void testifAlreadyin3(){
    	index = new IndexNode("Lam");
    	index.insert(1);
    	index.insert(2);
    	index.insert(3);
    	assertEquals("IndexNode should hold page 10", false, index.ifAlreadyin(10));
    }
}
