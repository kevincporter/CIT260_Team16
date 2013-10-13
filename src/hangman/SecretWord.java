/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author gerrygj
 */
public class SecretWord {

    String SecretWord = getWord();
    char[] SecretArray = new char[SecretWord.length()];
    char[] wordArray = new char[SecretWord.length()];
    int numberOfGuesses = 6; // we could have a difficulty setting that changes this value
    int count = 0;
    
    public SecretWord() {
        for(int i = 0; i < SecretArray.length; i++) {
            SecretArray[i] = '_';
        }
    }

public char getLetter() {
    Scanner letterScanner = new Scanner(System.in);
    char letter = '0';
    
    do {
        //System.out.println("Please enter a letter or enter 1 for the menu: ");
        
        // Added a tab escape and a math operator for the assignment. It will be deleted later. The original line is above this one.
        System.out.println("\tPlease enter a letter or enter " + (100-99) + " for the menu: ");
        
        letter = letterScanner.next().charAt(0);
    } while (Character.isLetter(letter) == false && letter != '1');
    
    return letter;
}
    
public String getWord() {
    String hangmanWord = "Kevin"; // User will assign the word with keyboard, for now it is just assigned
    return hangmanWord;
}    

public void displaySecretWord (char letter) {
    
    wordArray = SecretWord.toCharArray(); //type conversion
    boolean correctLetter = false;
    
    System.out.print("Secret word: ");
    
    for(int i = 0; i < wordArray.length; i++) {
        
        if (wordArray[i] == letter) {
            SecretArray[i] = letter;
            correctLetter = true;
        }
        
        System.out.print(SecretArray[i] + " ");
        
    }
    
    if (correctLetter == false) {
        count++;
    }
    
    System.out.print("(" +SecretWord.length() +" letters)\n");
}

public void guessesLeft(){
    System.out.println("You have " + (numberOfGuesses - count +1) + " guesses left.");
}

public boolean winGame () {
    
    if (Arrays.equals(wordArray, SecretArray)){
        return true;
    }
    else {
        return false;
    }
}

public boolean loseGame () {
    
    if (count > numberOfGuesses){
        return true;
    }
    else {
        return false;
    }
}

}