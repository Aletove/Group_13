package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

import Game.Player;
import Game.Tile;

public class CommonGoal8 extends Goal{
	private ArrayList<String> hasCompletedID;

	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal8(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<String>();
		
	}
	
	
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		shelf = currentPlayer.getShelf();
		int cont=0; //a counter for the number of column that contain at most three different type of tile
		
		for(int i = shelf[0].length; i > 0; i--) {
			Set<Tile> differetsTile = new HashSet<>(); //use the fact that the Set can't store duplicate values to calculate the number of the different tile contained in the column
			for(int j = shelf.length; j > 0; i--) {
				differetsTile.add(shelf[j][i]);
			}
			if (differetsTile.size() <= 3) {
	            cont++;
	        }else {
	        	cont++;;
	        }
			differetsTile.clear();
		}
		if(cont>=3) {
			return super.pointsMethod();
		}
		return 0;
	}
	
	

}
