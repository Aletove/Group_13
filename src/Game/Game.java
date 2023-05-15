package Game;


import java.util.ArrayList;
import java.util.Collections;

public class Game {
	    private ArrayList<Player> playerList = new ArrayList<>();
	    private Objective[] commonObjectives;
	    private Board board;
	    private int turn=0;
	    private boolean isLastround;

	    public void initGame(Player[] players, Objective[] commonObjectives, Board board) {
	    	for (Player player : players) {
	            this.playerList.add(player);
	        }
	    	Collections.shuffle(playerList);
	    	this.commonObjectives = commonObjectives;
	    	this.board = board;
	    }

	    public Player nextTurn() {
	    	this.turn += 1;
	    	int nextPlayerIndex = (this.turn - 1) % playerList.size();
	    	if(this.isLastround && nextPlayerIndex == 0) throw new Error("PARTITA TERMINATA");
	    	return this.playerList.get(nextPlayerIndex);
	    	//funzione che ritorna il player che dovrà giocare
	    }

	    public void match(int pickAreaRows[], int pickAreaColumns[], int shelfColumn) {
	    	//current player handling
	    	Player currentPlayer = this.nextTurn();
	        //pick tiles from the board
	    	ArrayList<Tile> tiles = board.pickTiles(pickAreaRows, pickAreaColumns);
	        //put tiles in the shelf
	    	currentPlayer.getShelf().fillColumn(shelfColumn, tiles);
	    	if(currentPlayer.getShelf().isFull()) this.isLastround = true;
	    }
	    
	    //funzione per terminare partita e fare il conteggio dei punti
	}
