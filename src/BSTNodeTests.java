import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing IndexNode functionalities
 * @author Lam Ngo
 * @version 06/02/2016
 * 
 * Note: IndexNode are essentially String since adding and removing indexNode are based on 
 * the string it carries, so I do not test it in here.
 * 
 * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class BSTNodeTests {
    private BSTNode<String> node;
    private BSTNode<String> anothernode;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        node = null;
    }
    
    @Test
    public void testCreate(){
    	node = new BSTNode<String>("Lam");
    	String expected= "Lam";
    	assertEquals("toString should look like this", expected, node.toString());
    }
    
    @Test
    public void testNodeWithRightLink(){
       	node = new BSTNode<String>("Lam");
       	anothernode = new BSTNode<String>("Linn");
    	node.rlink = anothernode;
    	String expected = "Linn";
    	assertEquals("node's right child's toString should look like this", expected, node.rlink.toString());
    }
    
    @Test
    public void testNodeWithLeftLink(){
       	node = new BSTNode<String>("Lam");
       	anothernode = new BSTNode<String>("Linn");
    	node.llink = anothernode;
    	String expected = "Linn";
    	assertEquals("node's left child's toString should look like this", expected, node.llink.toString());
    }
    
    @Test
    public void testNodeWithParent(){
       	node = new BSTNode<String>("Lam");
       	anothernode = new BSTNode<String>("Linn");
    	node.before = anothernode;
    	String expected = "Linn";
    	assertEquals("node's parent's toString should look like this", expected, node.before.toString());
    }
    
    @Test
    public void testisGreaterThan(){
       	node = new BSTNode<String>("Lam");
       	anothernode = new BSTNode<String>("Linn");
    	assertEquals("node should be smaller than another node", false, node.isGreaterThan(anothernode.key));
    }
}

