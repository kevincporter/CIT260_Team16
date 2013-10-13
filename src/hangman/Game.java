

package hangman;

public class Game {

   
    public Game() {
    }

    public void displayWinningMessage () {
        System.out.println(
             "\n\t*******************************************************************************"
             + "\n\t Congratulations. You win!"
             + "\n\t*******************************************************************************");
    }

    public void displayLosingMessage () {
        System.out.println(
             "\n\t*******************************************************************************"
             + "\n\t Sorry. You lose. Better luck next time!" 
             + "\n\t*******************************************************************************");

    }
   public void PlayGame() {
        
        SecretWord SecretWord = new SecretWord();
        SecretWord.displaySecretWord('_');
        SecretWord.guessesLeft();
        
        char SecretLetter;
                
        while (SecretWord.winGame() == false && SecretWord.loseGame() == false){
            
            SecretLetter = SecretWord.getLetter(); //Guessing
            
            if (SecretLetter == '1') {
                System.out.println("We will eventually build a real menu."); //this will be replaced with call to the menu class
            }
            else {
            //    AlphabetArray.displayAlphabetArray(SecretLetter);
                SecretWord.displaySecretWord(SecretLetter);
                SecretWord.guessesLeft();
            }
  //          }
        
  //      if (SecretWord.winGame()){
  //          MessagetoWinner();
  //      }
  //      else {
  //          MessagetoLooser();
  //      }
        
   }
   }
   }