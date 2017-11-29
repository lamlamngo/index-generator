/**
 * Generic node for the Binary Search Tree.
 * 
 * @author Lam Ngo
 * @version 06/02/2016
 *
 * @param <Element> The kind of element that is stored. Must be comparable
 * to Elements.
 * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class BSTNode<Element extends Comparable<Element>>
{
    /**
     * the value stored in the node.
     */
    public Element key;
    
    /**
     * a pointer to the left child of the node 
     */
    public BSTNode<Element> llink;
    
    /**
     * a pointer to the right child of the node 
     */
    public BSTNode<Element> rlink;
    
    /**
     * a pointer to a node's parent 
     */
    public BSTNode<Element> before;
    
    /**
     * Constructs a BSTNode for the given key.  The new node will be a 
     * leaf node.
     */
    /**
     * @param key
     */
    public BSTNode(Element key)
    {
        this.key = key;
        llink = null;
        rlink = null;
        before = null;
    }
    
    /**
     * return whether or not a node's data is greater than a certain data
     * @param e 
     * 			the data to be checked
     * @return true if the node's data is greater than the given data
     * 			and false otherwise.
     */
    /**
     * @param e
     * @return
     */
    public boolean isGreaterThan (Element e){
    	if (key.compareTo(e) > 0){
    		return true;
    	}else{
    		return false;
    	}
    }
    /**
     * @return the value stored in the node as a string
     */
    public String toString(){
    	return "" + key;
    }
}