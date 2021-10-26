public class PlayGame {

	public static void main(String[] args) {
		               // create a new game that starts with 21 coins with two players
		               // the left player's name is Thanos
		               // the right player's name is Captain America
		        Game game = new Game(21, new Player("Thanos"), new Player("Captain America"));
		       // they play two games
		       for (int count = 0; count < 2; count++) {
		          // let the game play itself until it's over
		         game.play();
		  
		         System.out.println("The game ended after " + game.getTurns() + " turns.");
		         System.out.println(game.getLeftPlayerName() + " took " + game.getLeftPlayerCoins() + " coins.");
		         System.out.println(game.getRightPlayerName() + " took " + game.getRightPlayerCoins() + " coins.");
		         System.out.println(game.winner() + " won the game by taking the last turn.");
		 
		          // reset the game to start over
		          game.reset();
		 
		          System.out.println("------");
		             }
		    }
}
