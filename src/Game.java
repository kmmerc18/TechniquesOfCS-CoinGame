// Kim Merchant
// This program creates a Game object, in which there are a number of coins on a table, 
// and two players who take turns taking one-three coins away. The person who has 
// no more coins to remove from the pile of coins loses.
// The Game object allows multiple rounds by resetting the game with the reset method
// when the game is over.
// No resources apart from class notes were used to create this.
// Gilligan's Island rule followed.

import java.util.Random;

public class Game {
	// instance variables
	private Player LeftPlayer;			// first player of the game
	private Player RightPlayer;			// second player of the game
	private int StartCoins;				// initial number of coins on the table
	private int CoinsLeft;				// variable number of coins left on the table during the game
	private int TurnsTaken;				// number of turns taken before the game is over
	private boolean WhoseTurn;			// which player's turn it is to take coins next
	
	// constructors
	public Game(int StartCoins, Player LeftPlayer, Player RightPlayer) { // creates a game object
		this.LeftPlayer = LeftPlayer;	// assigns a player object to the first player of the game
		this.RightPlayer = RightPlayer;	// assigns a player object to the second player of the game
		this.StartCoins = StartCoins;	// assigns an initial number of coins to be on the table
		this.CoinsLeft = StartCoins;	// initializes the number of coins left on the table
		TurnsTaken = 0;					// initializes the number of turns taken as zero
		Random flip = new Random();
		if (flip.nextInt(1) == 0) {		// randomly determines which player will take coins first
			WhoseTurn = true;
		}
		else WhoseTurn = false;
	}
	
	// instance methods
	public String getLeftPlayerName() {	// returns the name assigned to the first player object
		return LeftPlayer.getName();
	}
	
	public int getLeftPlayerCoins() {	// returns the number of coins 
		return LeftPlayer.getCoins();	// assigned to the first player object
	}
	
	public String getRightPlayerName() {	// returns the name assigned to the second player object
		return RightPlayer.getName();
	}
	
	public int getRightPlayerCoins() {		// returns the number of coins
		return RightPlayer.getCoins();		// assigned to the second player object
	}
	
	public int getTurns() {  				// returns the number of turns so far
		return TurnsTaken;
	}
	
	public String winner() { 				// returns the winner of the game 
		if (isOver() != true) {	// throws an exception if the winner is requested before the game ends
			throw new RuntimeException("The game isn't over yet!");
		}
		else if (WhoseTurn) {				// returns the right player's name if the right player won
			return RightPlayer.getName();  
		} 
		else if (WhoseTurn == false) {		// returns the left player's name if the left player won
			return LeftPlayer.getName();
		}
		return ("");						// returns an empty string if an exception is thrown
	}
	
	public void play() { 					// lets two players take turns until the game is over
		while (isOver() != true) {
			playOneTurn();
			TurnsTaken++;
			if (WhoseTurn == false) {		// after each turn, the variable determining whose turn it
				WhoseTurn = true;			// is changes to reflect the next person's turn
			} else {
				WhoseTurn = false;
			}
		}
	}
	
	public void reset() {					// resets the game to the initial conditions
		CoinsLeft = StartCoins;				
		Random flip = new Random();			// decides who goes first randomly
		if (flip.nextInt(1) == 0) {
			WhoseTurn = true;
		}
		else WhoseTurn = false;
		TurnsTaken = 0;						// resets the number of turns taken
		LeftPlayer.resetCoins();			// resets the number of coins the left player has to 0
		RightPlayer.resetCoins();			// resets the number of coins the right player has to 0
	}
	
	private void playOneTurn() { 			// lets the next player take a turn throws an exception
		if (isOver()) {						// does not let a player take a turn if the game is over
			throw new RuntimeException("The game is over."); 
		}
		if (WhoseTurn) {
			LeftPlayer.takeCoins(CoinsLeft);	// allows left player to take coins on its turn
			CoinsLeft = StartCoins - LeftPlayer.getCoins() 
					- RightPlayer.getCoins(); 	// decrements coins on table by amount taken by player
		} else if (WhoseTurn == false) {
			RightPlayer.takeCoins(CoinsLeft);	// allows right player to take coins on its turn
			CoinsLeft = StartCoins - LeftPlayer.getCoins() 
					- RightPlayer.getCoins(); 	// decrements coins on table by amount taken by player
		}
	}
	
	private int getCoinsLeft() {			// returns the number of coins left on the table
		return CoinsLeft;
	}
	
	private boolean isOver() { 				// returns true when the game is over (no more coins left 
		if (CoinsLeft <= 0) {				// on the table)								
			return true;
		} else {
			return false;
		}	
	}
}
