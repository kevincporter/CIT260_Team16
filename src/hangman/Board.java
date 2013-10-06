/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;


/**
 *
 * @author BlancoFamily
 */
public class Board {
    int rowCount = 5;
    int columnCount = 5;

    
    public void displaySize() {
        System.out.println("This board is " + this.rowCount + " by " 
                           + this.columnCount + " big, which is awesome.");
    }
}
