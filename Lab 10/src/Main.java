/**
 * Alexander  Pham
 * December 3, 2019
 * Add words to a binary search tree, while keeping it's frequency
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main ( String args[] ){
        while ( true ) {
            BST tree = createTree();
            displayMenu();
            int userChoice = CheckInput.getIntRange(1, 3);
            System.out.println();
            //Print alphabetically sorted tree
            if ( userChoice == 1 ){
                //Sort tree
                System.out.println( tree.toSortedString() );

            }
            //Print word and occurrence
            if ( userChoice == 2 ){
                System.out.print( "What word would you like to look for? : " );
                String userWordString = CheckInput.getString();
                Word userWord = new Word( userWordString );
                //If word not found
                if ( tree.contains( userWord ) !=  null ){
                    System.out.println( tree.contains( userWord ) );
                }
                //Word found
                else {
                    System.out.println( userWord  );
                    System.out.println( "Word not found" );
                }
            }
            //Quit
            if ( userChoice == 3 ){
                System.out.println( "Later loser" );
                break;
            }
            System.out.println();
        }
    }

    /**
     * Create tree
     * @return tree
     */
    public static BST createTree(){
        BST tree = new BST();
        try {
            Scanner read = new Scanner(new File("words.txt"));
            do {
                String wordString = read.nextLine();
                Word word = new Word( wordString );
                tree.add( word );
            } while ( read.hasNext() );
        } catch (FileNotFoundException fnf) {
            System.out.println( "File was not found" );
        }
        return tree;
    }
    /**
     * Display menu
     */
    public static void displayMenu(){
        System.out.print("1. List in alphabetical order\n" +
                "2. Search for word\n" +
                "3. Quit\n" +
                "Choose an option : ");
    }
}
