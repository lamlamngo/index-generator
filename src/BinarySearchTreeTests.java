import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Binary Search Tree tests
 * 
 * Note: IndexNode are essentially String since adding and removing indexNode are based on 
 * the string it carries, so I do not test it in here.
 * @author Lam Ngo
 * @version 06/02/2016
 * 
  * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class BinarySearchTreeTests {

    private BinarySearchTree<String> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree<String>();
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
    }

    @Test
    public void testBSTtoStringEmptyTree() {
        assertEquals("toString representation of an emtpy string", "", tree.toString());
    }

    @Test
    public void testBSTshowTreeEmptyTree() {
        assertEquals("showTree representation of an emtpy string", "-", tree.showTree());
    }

    @Test
    public void testBSTtoString() {
        tree.add("K");
        tree.add("D");
        tree.add("R");
        tree.add("B");
        tree.add("Z");
        assertEquals("Adding K, D, R, B, Z to an initially empty tree. Representation created by toString.", "B\nD\nK\nR\nZ", tree.toString());
    }

    @Test
    public void testBSTshowTree() {
        tree.add("K");
        tree.add("D");
        tree.add("R");
        tree.add("B");
        tree.add("Z");
        assertEquals("Adding K, D, R, B, Z to an initially empty tree. Representation created by showTree.", "(K (D (B - -) -) (R - (Z - -)))", tree.showTree());
    }

    @Test
    public void testRemovingOneNode(){
    	tree.add("Yoda");
    	tree.remove("Yoda");
    	assertEquals("Removing Yoda from (Yoda--)","-",tree.showTree());
    }
    
    @Test
    public void testRemovingOneNode2(){
    	tree.add("Yoda");
    	tree.remove("Darth Vader");
    	assertEquals("Removing 'Darth Vader' from (Yoda--)", "Yoda", tree.toString());
    }
    
    @Test
    public void testRemoveNodeWithNoChildren(){
    	tree.add("F");
    	tree.add("B");
    	tree.add("A");
    	tree.add("C");
    	tree.add("E");
    	tree.remove("E");
    	assertEquals("Removing a node with no children", "(F (B (A - -) (C - -)) -)", tree.showTree());
    }
    
    @Test
    public void testRemoveNodeWithOnlyRightChild(){
    	tree.add("K");
    	tree.add("E");
    	tree.add("F");
    	tree.add("A");
    	tree.add("B");
    	tree.add("C");
    	tree.remove("A");
    	assertEquals("Removing a node with only right child", "(K (E (B - (C - -)) (F - -)) -)",tree.showTree());
    }
    
    @Test
    public void testReMoveNodeWithBothChildren(){
    	tree.add("L");
    	tree.add("F");
    	tree.add("G");
    	tree.add("D");
    	tree.add("A");
    	tree.add("E");
    	tree.add("D");
    	tree.add("B");
    	tree.add("C");
    	tree.remove("D");
    	assertEquals("Removing a node with both children", "(L (F (D (A - (C (B - -) -)) (E - -)) (G - -)) -)", tree.showTree());
    }
    
    @Test
    public void testRemoveOneNodeWrong(){
    	tree.add("Lam");
    	tree.remove("Witch");
    	assertEquals("Removing 'Wtich' from (Lam - -)", "(Lam - -)", tree.showTree());
    }
    @Test
    public void testRemoveWithOnlyLeftChild(){
    	tree.add("A");
    	tree.add("K");
    	tree.add("B");
    	tree.add("A");
    	tree.add("D");
    	tree.add("C");
    	tree.add("E");
    	tree.remove("K");
    	assertEquals("Removing a node with only left child", "(A (A - -) (E (B - (D (C - -) -)) -))", tree.showTree());
    }
    
    @Test
    public void testRemoveOneNodeTree(){
    	tree.add("Linn");
    	tree.remove("Linn");
    	assertEquals("Removing the root node of a one node tree", "-", tree.showTree());
    }
    
    @Test
    public void testRemoveRootWithOnlyRightChild(){
    	tree.add("all");
    	tree.add("same");
    	tree.add("day");
    	tree.add("word");
    	tree.add("bell");
    	tree.remove("all");
    	assertEquals("Removing the root node with only right children", "(same (day (bell - -) -) (word - -))", tree.showTree());
    }
    
    @Test
    public void testRemoveRootWithLeftAndRightChild(){
    	tree.add("same");
    	tree.add("word");
    	tree.add("bell");
    	tree.add("all");
    	tree.add("day");
    	tree.remove("same");
    	assertEquals("Removing the root node with both children", "(day (bell (all - -) -) (word - -))", tree.showTree());
    }
    
    @Test
    public void testRemoveRootWithOnlyLeftChild(){
    	tree.add("same");
    	tree.add("bell");
    	tree.add("all");
    	tree.add("day");
    	tree.add("cuckoo");
    	tree.remove("same");
    	assertEquals("Removing the root node with only left children", "(day (bell (all - -) (cuckoo - -)) -)", tree.showTree());
    }
    
    @Test
    public void testFindRoot(){
    	tree.add("L");
    	tree.add("F");
    	tree.add("G");
    	tree.add("D");
    	tree.add("A");
    	tree.add("E");
    	tree.add("D");
    	tree.add("B");
    	tree.add("C");
    	assertEquals("Finding root", "L", tree.find("L"));
    }
    
    @Test
    public void testFindleaf(){
    	tree.add("L");
    	tree.add("F");
    	tree.add("G");
    	tree.add("D");
    	tree.add("A");
    	tree.add("E");
    	tree.add("D");
    	tree.add("B");
    	tree.add("C");
    	assertEquals("Find a leaf", "C", tree.find("C"));
    }
    
    @Test
    public void findInternalNode(){
    	tree.add("L");
    	tree.add("F");
    	tree.add("G");
    	tree.add("D");
    	tree.add("A");
    	tree.add("E");
    	tree.add("D");
    	tree.add("B");
    	tree.add("C");
    	assertEquals("Find an internal node", "D", tree.find("D"));
    }
    
    @Test
    public void findNonexistentNode(){
    	tree.add("L");
    	tree.add("F");
    	tree.add("G");
    	tree.add("D");
    	tree.add("A");
    	tree.add("E");
    	tree.add("D");
    	tree.add("B");
    	tree.add("C");
    	assertEquals("Find a node that is not in the tree", null, tree.find("K"));
    }
}
