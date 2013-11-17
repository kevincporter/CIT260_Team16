
package hangman;
/**
 *
 * @author BlancoFamily
 */
public class MainMenuControl {
    
    boolean exitProgram = false;
    boolean startNewGame = false;
    
    public void activateControl(char menuSelection) {
                  
        switch(menuSelection){
            case 'A':
                startNewGame = true;
            break;
            
            case 'B':
               //Will give the option to play vs a second player 
            break;

            case 'H':
               //Will display Help options     
            break;
                
            case 'Q':
                exitProgram = true;
            break;
            
            default:
                System.out.println();
            }
    }

    public boolean newGame () {
        return startNewGame;
    }
    
    public void resetNewGame () {
        startNewGame = false;
    }
    
    public boolean exitGame () {
        return exitProgram;
    }
            
    
}
