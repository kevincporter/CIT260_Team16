/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import java.util.Scanner;
/**
 *
 * @author BlancoFamily
 */


public class MainMenuView {
    
  
    
    public char MenuOptions(){
    Errors Errors = new Errors();    
    Scanner inputScanner = new Scanner(System.in);
    
    String MenuDisplay =  "\nSelect one of the following options:"
                + "\nA. Versus Computer,"
                + "\nB, Two player game"
                + "\nH, Help"
                + "\nQ, Quit Hangman";
    
    String menuSelection = "1";
   
    do {
                  
    
  menuSelection = inputScanner.next();

  } 
   while (Errors.isInteger(menuSelection) == false || menuSelection.charAt(0) < '2' || menuSelection.charAt(0) > '5');
  
   return menuSelection.charAt(0);
        }
  
    
 }

    
    