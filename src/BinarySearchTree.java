/**
 * Represents a Binary Search Tree that stores elements.
 * 
 * @author Lam Ngo
 * @version 06/01/2016
 * @param <Element> The kind of element that is stored. Must be comparable
 * to Elements.
 * 
 * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class BinarySearchTree<T extends Comparable<T>>{

    /**
     * A pointer to the tree's root
     */
    private BSTNode<T> root;
    
    /**
     * A default constructor, initializing root to null (an empty tree)
     */
    public BinarySearchTree(){
    	root = null;
    }
    
    /** 
     * After the new node is added to the tree, the method
     * returns the root of the subtree.
     * 
     * Recursive defn of a binary search tree: a binary search tree is either empty OR
     * a single BSTnode, whose left link and right link each points to a binary search tree.
     * 
     * BASE CASE: GET TO AN EMPTY TREE
	 * PSEUDOCODE:
     * to return a pointer to the root of the subtree where newNode is added correctly, you either:
     * 		+	return newNode if subtreeRoot points an empty binary search tree, OR
     * 		+	return subtreeRoot, whose left or right link now points to a subtree where
     * 			newNode is added correctly.
     * 
     * @param subtreeRoot 
     * 					the root of the subtree to which to add.  If
     *            		null, the subtree is empty
     * @param newNode 
     * 					the node to add to the subtree.
     * @return the root of the subtree after newNode has been added.
     */
    private BSTNode<T> add(BSTNode<T> subtreeRoot, BSTNode<T> newNode) 
    {
    	if (subtreeRoot == null){
    		return newNode;
    	}else{
    		if (newNode.isGreaterThan(subtreeRoot.key)){
    			subtreeRoot.rlink = add(subtreeRoot.rlink,newNode);
    			subtreeRoot.rlink.before = subtreeRoot;
    			return subtreeRoot;
    		}else{
    			subtreeRoot.llink = add(subtreeRoot.llink,newNode);
    			subtreeRoot.llink.before = subtreeRoot;
    			return subtreeRoot;
    		}
    	}
    }
    
    /**Adds an element to the tree
     * @param toAdd
     * 				the element to add
     */
    public void add(T toAdd){
    	BSTNode<T> newNode = new BSTNode<T>(toAdd);
    	root = add(root, newNode);
    }
    
    /**Remove an element from the tree
     * @param toRemove
     * 				the element to remove
     */
    public void remove(T toRemove){
    	remove(root,toRemove);
    }

    /**
     * Remove a node from a tree.
     * Algorithm:
     * 			1. Find the node with the value to delete
     * 			2. If it does not have any children, delete it.
     * 			3. If it does not have a left child, the right child takes it place.
     * 			4. it if does have a left child: find the largest value in the nodes and let
     * 			that takes place of the node.
     * @param curroot
     * 				the root of the current subtree
     * @param toRemove
     * 				the element to be removed
     */
    private void remove(BSTNode<T> curroot, T toRemove){
    	if (curroot != null){
    		
    		if (curroot.key.compareTo(toRemove) < 0){
    			
    			remove(curroot.rlink,toRemove);
    		}else if(curroot.key.compareTo(toRemove) > 0){
    			
    			remove(curroot.llink,toRemove);
    		}else{
    			
    			if (curroot.llink == null && curroot.rlink == null){
    				// if the tree is a one node tree (deleting the root node)
    				if (curroot.before == null){
    					
    					root = null;
    				}else if (curroot.key.compareTo(curroot.before.key) > 0){
    					
    					curroot.before.rlink = null;
    				}else{
    					
    					curroot.before.llink = null;
    				}
    			}else if(curroot.llink == null){
    				// if we are deleting the root node
    				if (curroot.before == null){
    					root = curroot.rlink;
    					curroot.rlink.before = null;
    				}else if (curroot.key.compareTo(curroot.before.key) > 0){
    					
    					curroot.before.rlink = curroot.rlink;
    					curroot.rlink.before = curroot.before;
    				}else{
    					
    					curroot.before.llink = curroot.rlink;
    					curroot.rlink.before = curroot.before;
    				}
    			}else if(curroot.llink != null){
    				
    				BSTNode<T> toReplace = findLargest(curroot.llink);
    				curroot.key = toReplace.key;
    				remove(curroot.llink,toReplace.key);
    			}
    		}
    	}
    }

    /**A private helper method that finds the largest node in a subtree
     * @param subtreeRoot
     * 					The root of the subtree
     * @return
     * 			the largest node
     */
    private BSTNode<T> findLargest(BSTNode<T> subtreeRoot){
    	if (subtreeRoot.rlink == null){
    		return subtreeRoot;
    	}else{
    		return findLargest(subtreeRoot.rlink);
    	}
    }
    
    /**
     * Searches for an element in the tree.
     * 
     * @param toFind
     *            the element to search for
     * @return the element stored in the node
     */
    public T find(T toFind)
    {
        return find(root, toFind);
    }

    /**
     * Searches for an element in a subtree of the tree.
     * 
     * @param subtreeRoot
     *            the root of the subtree in which to search
     * @param toFind
     *            the element to search for
     * @return the element stored in the node
     */
    private T find(BSTNode<T> subtreeRoot, T toFind)
    {
    	if (subtreeRoot == null) {
            return null;
        } else if (subtreeRoot.key.compareTo(toFind) == 0) {
            return subtreeRoot.key;
        } else if (subtreeRoot.key.compareTo(toFind) > 0) {
            return find(subtreeRoot.llink, toFind);
        } else {
            return find(subtreeRoot.rlink, toFind);
        }
    }

    /**
     * Traverse the tree in-orderly
     * @param N
     * 			the starting node
     * @return
     * 			An in-order string presentation of the binary search tree
     */
    private String inOrderString(BSTNode<T> N)
    {
    	String result = "";
        if (N != null) 
        {    
        	result += inOrderString(N.llink);
        	result += N.toString() + "\n";
        	result += inOrderString(N.rlink);
        }
        return result;
    }
    
    /**
     * Traverse the tree pre-orderly
     * @param N
     * 			the starting node
     * @return
     * 			A pre-order string presentation of the binary search tree
     */
    private String preOrderString(BSTNode<T> N)
    {
    	String result = "";
        if (N != null) 
        {    
        	result += "(" + N.toString();
        	result += preOrderString(N.llink);
        	result += preOrderString(N.rlink);
        	result += ")";
        }else{
        	result += "-";
        }
        return result;
    }
    
    /**
     * @return A string representing the elements of the tree "in-orderly" (from small to large)
     */
    public String toString(){
    	return inOrderString(root).trim();
    }
    
    /**
     * @return a string showing the elements of the tree in pre-order order.
     * 			(Root LeftSubTree RightSubTree)
     */
    public String showTree(){
    	String result = preOrderString(root);
    	result = result.replace("("," (").trim();
    	result = result.replace("-", " -").trim();
    	return result;
    }
}
