
/**
 * Represent an index entry with the word and the pages it appears in
 * 
 * @author Lam Ngo
 * @version 06/02/2016
 * 
  * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class IndexNode implements Comparable<IndexNode> {
	/**
	 * page list can only hold 4 pages
	 */
	private static final int MAXPAGE = 4;
	
	/**
	 * the word stored in the indexNode
	 */
	private String word;
	
	/**
	 * an array keeping track of the pages the word appears in 
	 */
	private int[] pageList;
	
	/**
	 * the current page of the word
	 */
	private int curpage;
	
	/**
	 * Create an index node with the given String
	 * an IndexNode's page list can only hold 4 pages. 
	 * @param word
	 * 				the index's word
	 */
	public IndexNode(String word){
		this.word = word;
		pageList = new int[MAXPAGE];
		curpage = 0;
	}
	
	/**
	 * @return true if the indexNode already holds 4 pages
	 * 			false otherwise
	 */
	public boolean ifFull(){
		return (curpage == MAXPAGE);
	}
	
	/**
	 * @param pageNumber
	 * 				the page number to be checked
	 * @return	true if the indexNode already holds the given page number
	 * 			and false otherwise
	 */
	public boolean ifAlreadyin(int pageNumber){
		for (int loc = 0; loc < MAXPAGE; loc++){
			if (pageList[loc] == pageNumber){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Insert a page number into the indexNode
	 * Pre-condition: IndexNode's page list is not full
	 * @param pageNumber
	 * 				the page number to be inserted
	 */
	public void insert(int pageNumber){
		if (!ifFull()){
			pageList[curpage] = pageNumber;
			curpage++;
		}
	}
	/**
	 * @return 0 if the word contained in the indexNode is the same
	 * 			1 if the word contained in the indexNode is bigger alphabetically
	 * 			-1 if otherwise
	 * 
	 */
	public int compareTo(IndexNode otherNode){
		if (word.compareTo(otherNode.word) > 0){
			return 1;
		}else if(word.compareTo(otherNode.word) == 0){
			return 0;
		}else{
			return -1;
		}
	}
	
	/**
	 * @return the word stored in the node
	 */
	public String toString(){
		String result = word + ":";
		for (int loc = 0; loc < curpage; loc++){
			if (loc == curpage-1){
				result += " " + pageList[loc];
			}else{
				result += " " + pageList[loc] +",";
			}
		}
		return result;
	}
}

