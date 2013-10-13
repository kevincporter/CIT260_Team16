/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author BlancoFamily
 */
public class Gallow {
    String gallow = 
           "____________\n"
          +"|           |\n"
          +"|           |\n"
          +"|\n"
          +"|\n"
          +"|\n"
          +"|\n"
          +"|\n"
          +"|\n"
          +"|\n"
          +"|\n"  
          +"|\n"
     +"-----------\n";
    
   //This will be what is displayed if user has 1 error
    
  //   String gallow&Head = 
  //         "____________\n"
  //        +"|           |\n"
  //         +"|           |\n"
  //        +"|         |---|\n"
  //        +"|        | ^ ^ |\n"
  //        +"|         |___| \n"
  //        +"|\n"
  //        +"|\n"
  //        +"|\n"
  //        +"|\n"
  //        +"|\n"  
  //        +"|\n"
  //   +"-----------\n";

    
    public String displayGallow(){
        System.out.println(gallow);
        return null;
    }
    
    public void displayWrongLetterBox(){
        System.out.println("ToDo: Display wrong letter box");
    }    
    
}
