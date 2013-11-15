/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;


public class GameMenuControl {
    
    private Game game;
    private Board board;
    private GetLocationView getLocationView;
    private BoardView boardView = new BoardView();

    
    public GameMenuControl(Game game) {
        this.game = game;
        this.board = game.board;
    }
    
     
    /* 
     * Take a turn action
     */
    public void takeTurn() {
        
        int returnValue = 1;
        
        if (!this.game.status.equals(Game.NEW_GAME)  && 
            !this.game.status.equals(Game.PLAYING)) {
            new HangmanError().displayError("You must start a new game first.");
            return;
        }
        
        if (this.game.gameType.equals(Game.TWO_PLAYER)) { //two player game 
            // regular player takes turn
            returnValue = this.regularPlayerTurn(this.game.currentPlayer);            
            if (returnValue < 0  || this.gameOver(this.game.currentPlayer)) {
                return;
            }
            this.displayBoard();
            this.alternatePlayers(); // alternate players             
            
            // other player takes turn 
            returnValue = this.regularPlayerTurn(this.game.currentPlayer);            
            if (returnValue < 0  || this.gameOver(this.game.currentPlayer)) {
                return;
            }
            this.displayBoard();
            this.alternatePlayers(); // alternate players
        }
        
        else { // one player game
            // regular player takes turn
            this.regularPlayerTurn(this.game.currentPlayer);
            if (returnValue < 0  || this.gameOver(this.game.currentPlayer)) {
                return;
            }
        
            // computer takes turn         
            this.coumputerTakesTurn(this.game.otherPlayer);
            System.out.println("\n\tThe computer also took it's turn");
            this.displayBoard();            
            if (returnValue < 0  || this.gameOver(this.game.otherPlayer)) {
                return;
            }
        }
    
    }   
    
    
    /*
     * Display the board acton
     */
    public void displayBoard() {
        boardView.displayBoard(this.board);
    }
    
    /*
     * Start a new game action
     */
    public void startNewGame() {
        this.game.start();
        this.displayBoard();
    }
  
    
  
    
    /*
     * Display statistics action
     */
     public void displayStatistics() {
        String playerAStatistics = this.game.playerA.getPlayerStastics();
        String playerBStatistics = this.game.playerB.getPlayerStastics();
        System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\t " + playerAStatistics);
        System.out.println("\n\t " + playerBStatistics);
        System.out.println("\t+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
     
     /*
      * Display game preferences menu action
      */
    public void displayPreferencesMenu() {
        GamePreferencesMenuView gamePreferenceMenuView = new GamePreferencesMenuView(this.game);
        gamePreferenceMenuView.getInput();
    }
    
    
    /*
      * Display help menu action
      */
    public void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.getInput();
    }
    
    /* 
     * determine if the game is over
     * @return true - if the game is a win or a tie; otherwise, return false
     */    
    private boolean gameOver(Player player) {
        if (this.isWinner()) {
            this.game.status = Game.WINNER;
            this.displayGameOverMessage(player, "Congratulations! You won the game.");
            
            return true;
        }
        else if (this.isTie()) {
            this.game.status = Game.TIE;
            this.displayGameOverMessage(player, "Better luck next time. The game is a tie.");
            return true;
        } 
        
        return false;
    }
    
    private void displayGameOverMessage(Player player, String message) {
        System.out.println("\n\t************************************************");
        System.out.println("\t " + player.name + ": " + message);
        System.out.println("\t************************************************");
    }
    
    /*
     * A regular player takes a turn
     * @parameter player The player taking the turn
     */
    private int regularPlayerTurn(Player player) {
        
        if (!this.game.status.equals(Game.NEW_GAME)  &&
            !this.game.status.equals(Game.PLAYING)) {
            new TicTacToeError().displayError(
                    "There is no active game. You must start a new game before "
                    + "you can take a turn");
            return -1;
        } 
        
        this.game.status = Game.PLAYING;
        
        GetLocationView getLocationView = new GetLocationView(this.game);
        Point location = getLocationView.getInput();
        if (location == null) { // no location was entered?
            return -1;
        }
            
        this.game.board.occupyLocation(player, location.x, location.y);
        
        return 0;
    }
    
     /*
     * A regular player takes a turn
     * @parameter player The player who is the computer
     */
    private void coumputerTakesTurn(Player player) {
        // computer takes turn 
        Point location = this.getComputersSelection();
        this.game.board.occupyLocation(player, location.x, location.y);
        return;
    }
    


    /*
     * Alternate players
     */
    public void alternatePlayers() {
        if (this.game.currentPlayer == this.game.playerA) {
            this.game.currentPlayer =  this.game.playerB ;
            this.game.otherPlayer =  this.game.playerA;
        } else {
            this.game.currentPlayer =  this.game.playerA;
            this.game.otherPlayer =  this.game.playerB ;
        }
    }
    


    
    
    /* 
     * Get computers selection
     */
    private Point getComputersSelection() {
        Point coordinate;

        coordinate = this.findWinningLocation(game.currentPlayer);
        if (coordinate != null) { // winning location found for computer
            return coordinate;
        }

        // find winning location for other player
        coordinate = this.findWinningLocation(game.otherPlayer);
        if (coordinate == null) { // no winning location found for other player
            coordinate = this.chooseRandomLocation();

            if (coordinate == null) {
                new TicTacToeError().displayError("No empty locations found on the board");
                return null;
            }
        }
   
        return coordinate;
    }



    /* 
     * Is the game tied?
     */ 
    private boolean isTie() {
        
        Player[][] locations = this.board.getBoardLocations();
        
        // for every row in the table
        for (int row = 0; row < locations.length; row++) {
            
            Player[] rowLocations = locations[row];
            
            // for every column in the row
            for (int col = 0; col < rowLocations.length; col++) {
                Player location = rowLocations[col]; // get contents of cell
                if (locations[row][col] == null) { // location not taken yet?
                    return false;
                }
            }
        }

        return true; // all locations are taken
    }

    /*
     * Is the game won
     */
    private boolean isWinner() {

        Player[][] locations = this.board.getBoardLocations();

        // for every row in the table
        for (int row = 0; row < locations.length; row++) {
            
            // get the list of locstaions (columns) in the row
            Player[] rowLocations = locations[row];
            
            // for every column in the row
            for (int col = 0; col < rowLocations.length; col++) {
                
                // three of the same players markers in a row?
                if (threeInARow(row, col, locations)) { 
                    return true; // three in a row found (a winner)
                }
            }
        }

        return false; // no one is a winner yet
    }

  



        return null; // not found
    }


    
 
        
}