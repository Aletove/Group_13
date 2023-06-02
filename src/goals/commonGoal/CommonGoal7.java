package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal7 extends Goal {
	private ArrayList<Integer> hasCompletedID;
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @author Giuseppe Luisi
	 * @param nPlayers
	 */
	public CommonGoal7(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<Integer>();
	}
	
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		HashSet<Tile> tileTypes;
		int rows, cols, validRows = 0;
		boolean isValidRow;
		Tile currentTile;
		shelf = currentPlayer.getShelf();
		rows = shelf.length;
		cols = shelf[0].length;
		isValidRow = true;
		
	//check each row of the shelf
	for(int i = 0; i < rows; i++) {
		tileTypes = new HashSet<Tile>();
		isValidRow = true;
		//check each column in the current row
		for(int j = 0; j < cols && isValidRow; j++) {
			currentTile = shelf[i][j];
			if(!currentTile.equals(Tile.EMPTY)) {//If the row has one or more empty tiles, is not valid.
				if(!tileTypes.add(currentTile)) {
				}
			}else {
				isValidRow = false;
			}
		}
		if(isValidRow && tileTypes.size()==5) {
			validRows++;
		}
	}
	//check if the goal was reached
	if(validRows > 1) {
		if(super.notCompletedYet(currentPlayer, hasCompletedID)) {
			return super.pointsMethod();
		}
		System.out.println("Goal reached"); //Goal reached, two rows each made up of five different types of tiles
	}
	return 0;
}


}
