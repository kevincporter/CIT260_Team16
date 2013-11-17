
package hangman;


/**
 *
 * @author testBlancoFamily
 */
public class Board {
    int rowCount = 5;
    int columnCount = 5;

    
    public void displaySize() {
        System.out.println("This board is " + this.rowCount + " by " 
                           + this.columnCount + " big, which is awesome.");
    }
}
