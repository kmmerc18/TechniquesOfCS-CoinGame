// Kim Merchant
// This program allows the creation of a Player object, with a variable name and number of coins.
// The number of coins can be altered multiple ways, or reset to the original 0.
// No resources apart from class notes were used to create this.
// Gilligan's Island rule followed.

import java.util.Random;			
public class Player {
	Random randomizer = new Random();	// later used for takeCoins method
	
	
	// instance variables
	private String PlayerName;			// variable name of the individual player object
	private int PlayerCoins;			// variable integer assigned to individual player object
	
	// constructors
	public Player(String PlayerName) {	// creates a player object
		this.PlayerName = PlayerName;	// uses input PlayerName as name of player object
		this.PlayerCoins = 0;			// assigns each player object a default 0 coins
	}
	
	// instance methods
	public String getName() {			// returns player name
		return this.PlayerName;
	}
	
	public int takeCoins(int coinsOnTheTable) {		// allows player to randomly take one-three
		int takenCoins = randomizer.nextInt(3) + 1;	// coins from table
		while (takenCoins > coinsOnTheTable) {		// keeps player from taking more coins than 
			takenCoins = randomizer.nextInt(3) + 1; // are on the table
		}
		this.PlayerCoins += takenCoins;				// increments player object's coins by takenCoins
		return takenCoins;							// returns the number of taken coins
	}
	
	public int getCoins() {		 	// returns the number of coins this player object has
		return this.PlayerCoins;
	}
	
	public void resetCoins() {		// resets the number of coins a player object has to 0
		this.PlayerCoins = 0;
	}
	
}
