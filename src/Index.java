
/**
 * Create an index that tells on what pages you can find certain keywords for any given text files.
 * 
 * @author Lam Ngo
 * @version 06/02/2016
 * 
  * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class Index {
	/**
	 * A string containing all punctuations 
	 */
	private static final String PUNCTUATION = "!\"”“‘’….',;:.-_?)(/[]{}<>*#\n\t\r$%^&";
	
	/**
	 * a FileReader object to read text files
	 */
	private FileReader myReader;
	
	/**
	 * A binary Search Tree that will holds the words that appears more than 4 times
	 */
	private BinarySearchTree<String> myDictionary;
	
	/**
	 * A binary search tree that will holds keywords and they pages it appears on 
	 */
	private BinarySearchTree<IndexNode> myIndex;
	
	/**
	 * an int keeping track of the page the program is currently on 
	 */
	private int pageNumber;
	
	/**
	 * A default constructor that creates an empty Index
	 */
	public Index(){
		myDictionary = new BinarySearchTree<String>();
		myIndex = new BinarySearchTree<IndexNode>();
		pageNumber = 1;
	}

	/**
	 * Fills the index using the words in the given document file
	 * @param filename
	 * 				the given text file
	 */
	public void createIndexFromFile(String filename){
		IndexNode indexNode;
		myReader = new FileReader(filename);
		String token = myReader.nextToken();
	// while there are still words to process
		while (token != null){
	// if the token is #, increment page number
			if (token.equals("#")){
				pageNumber ++;
			}else{
				token = cleanToken(token,PUNCTUATION);
				token = token.toLowerCase();
				indexNode = new IndexNode(token);
				
	// if token is 3 chars or longer and token is not in the dictionary
				if (token.length() >= 3 && myDictionary.find(token) == null){
					
	// if token is already in the index
					if (myIndex.find(indexNode) != null){
						
	// if word's page list doesnt yet have this page number
						if (!myIndex.find(indexNode).ifAlreadyin(pageNumber)){
							
	// if word's page list isnt full
							if (!myIndex.find(indexNode).ifFull()){
								myIndex.find(indexNode).insert(pageNumber);
							}else{		
								myIndex.remove(indexNode);
								myDictionary.add(token);
							}
						}
					}else{
						indexNode.insert(pageNumber);
						myIndex.add(indexNode);
					}
				}
			}
	// get a new token
			token = myReader.nextToken();
		}
    }
	
	/**
	 * strip a string off any leading or trailing punctuation
	 * @param source
	 * 				the string to be stripped
	 * @param trimChars
	 * 				all punctuation to be removed
	 * @return
	 */
	private String cleanToken(String source, String trimChars) {
	    char[] chars = source.toCharArray();
	    int length = chars.length;
	    int start = 0;

	    while (start < length && trimChars.indexOf(chars[start]) > -1) {
	        start++;
	    }

	    while (start < length && trimChars.indexOf(chars[length - 1]) > -1) {
	        length--;
	    }

	    if (start > 0 || length < chars.length) {
	        return source.substring(start, length);
	    } else {
	        return source;
	    }
	}
	
	/**
	 * Prints out the constructed index
	 */
	public void printIndex(){
		String result = "INDEX:\n";
		result += "======\n";
		result += myIndex.toString();
		System.out.println(result);
	}
	
	/**
	 * Prints out the words that were not included in the index.
	 */
	public void printExcludedWords(){
		String result = "DICTIONARY of excluded words:\n";
		result += "=============================\n";
		result += myDictionary.toString();
		System.out.println(result);
	}
}
