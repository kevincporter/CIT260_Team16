/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Hangman {

  //Variables 
    
    
    
  //Instant Variable
  String name;
  String instructions = "This is a game of Hangman \n\n"
                        +"The object of the game is to guess a word without \n"
                        +"getting the man hung. You have a limited amount of\n"
                        +"guesses, so be wise in picking a lettor or word.\n\n"
                        +"Good Luck!";
          
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Hangman myGame = new Hangman();
    myGame.getName();
    myGame.displayHelp();
    Gallow gallow = new Gallow ();
    gallow.displayGallow();
    gallow.displayWrongLetterBox();
    
   Game game = new Game();
        game.PlayGame(); 
    // TODO code application logic here
  }
  
  public void getName() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your name: ");
    this.name = input.next();
  }
  
  public void displayHelp(){
    System.out.println("\nWelcome " + this.name + "\n");
    System.out.println(this.instructions);
    
      
  }
  }
