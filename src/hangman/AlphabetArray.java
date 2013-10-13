/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author Team1
 */
public class AlphabetArray {

    // The array to contain the alphabet
    char[] alphabetArray = new char[26];
    
    public AlphabetArray() {
    }

public void makeAlphabet (){
    alphabetArray= "abcdefghijklmnopqrstuvwxyz".toCharArray(); //type conversion
}
    
public void AlphabetArrayDisp (char letter) {
    
    System.out.println("Remaining Letters:");
    
    for(int i = 0; i < alphabetArray.length; i++) {
        
        if (alphabetArray[i] == letter) {
            alphabetArray[i] = '_';
        }
        
        System.out.print(alphabetArray[i] + " ");
    }
    
    //System.out.print("\n\n");
    
    // Added a tab escape and a math operator for the assignment. It will be deleted later. The original line is above this one.
    System.out.print("\n\t***Here's some math just for the assignment: 1*2*3*4*5 = " + 1*2*3*4*5 + "\n");
        
}

}