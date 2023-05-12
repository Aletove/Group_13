package Game;


import java.util.ArrayList;
import java.util.Collections;

public class Game {
	    private Player[] players;
	    private Objective[] commonObjectives;
	    private Board board;

	    public Game(Player[] players, Objective[] commonObjectives, Board board) {
	        this.players = players;
	        this.commonObjectives = commonObjectives;
	        this.board = board;
	    }

	    public void match() {
	        // Shuffling the player array list
	        ArrayList<Player> playerList = new ArrayList<>();
	        for (Player player : players) {
	            playerList.add(player);
	        }
	        Collections.shuffle(playerList);

	        // Associating the chair with the first player of the shuffled array list
	        Player firstPlayer = playerList.get(0);
	        board.setChair(firstPlayer);

	        // Start the game
	        // Implement game logic
	    }

	    public void turn(Player currentPlayer) {
	        // Implement turn logic for the current player
	    }

	    public boolean pickTiles(int pickAreaRows, int pickAreaColumns, Player currentPlayer) {
	        // Calling the pickTiles method in the board and handling the result
	        boolean result = board.pickTiles(pickAreaRows, pickAreaColumns);
	        // Implement additional logic based on the result

	        return result;
	    }
	}
