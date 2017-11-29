
/**
 * Runs the program
 * @author Lam Ngo
 * @version 02/06/2016
 * 
  * I have read the syllabus and understand what outside sources I am allowed to consult for this
 *class and how I am allowed to discuss the class projects with other people. I confirm that I have
 *done all my work on this project according to the guidelines in the syllabus.
 * Signature: Lam Ngo 
 */
public class Client {
    /**
     * the main method that runs the program
     * @param args
     */
    public static void main(String[] args) {
     	System.out.println("allsameword.txt");
     	Index newIndex = new Index();
     	newIndex.createIndexFromFile("data/allsameword.txt");
    	newIndex.printIndex();
    	newIndex.printExcludedWords();
    	System.out.println("\n");	
    	
    	System.out.println("mirco-input.txt");
    	newIndex = new Index();
    	newIndex.createIndexFromFile("data/micro-input.txt");
    	newIndex.printIndex();
    	newIndex.printExcludedWords();
    	System.out.println("\n");
//    	
    	System.out.println("myInput");
    	newIndex = new Index();
    	newIndex.createIndexFromFile("data/myInput.txt");
    	newIndex.printIndex();
    	newIndex.printExcludedWords();
    	System.out.println("\n");
    	
    	System.out.println("MyInput2");
    	newIndex = new Index();
    	newIndex.createIndexFromFile("data/Test.txt");
    	newIndex.printIndex();
    	newIndex.printExcludedWords();
    	System.out.println("\n");
    	
    	System.out.println("input");
    	newIndex = new Index();
    	newIndex.createIndexFromFile("data/input.txt");
    	newIndex.printIndex();
    	newIndex.printExcludedWords();
    	System.out.println("\n");
//    	
    	System.out.println("usconst");
    	newIndex = new Index();
    	newIndex.createIndexFromFile("data/usconst.txt");
    	newIndex.printIndex();
    	newIndex.printExcludedWords();
    	System.out.println("\n");    
    }

}
