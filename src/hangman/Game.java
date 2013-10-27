

package hangman;

public class Game {

   
    public Game() {
    }

    public void MessagetoWinner () {
        System.out.println(
             "\n\t*******************************************************************************"
             + "\n\t Congratulations. You win!"
             + "\n\t*******************************************************************************");
    }

    public void MessagetoLooser () {
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
     //           System.out.println(this.MenuDisplay); How can I connect this to my string in MainMenuView? Or how would it be best?
            }
            else {
               // AlphabetArray.AlphabetArray(SecretLetter);
                SecretWord.displaySecretWord(SecretLetter);
                SecretWord.guessesLeft();
            }
            }
        
        if (SecretWord.winGame()){
            MessagetoWinner();
        }
        else {
            MessagetoLooser();
        }
        
   }
   }
   