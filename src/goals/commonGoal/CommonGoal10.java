package goals.commonGoal;

import game.*;
import goals.*;
import java.util.*;

public class CommonGoal10 extends Goal {
	private ArrayList<Integer> hasCompletedID;

	/**
	 * The constructor generates the array list points, based on the number of
	 * players.
	 * 
	 * @param nPlayers
	 */
	public CommonGoal10(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<Integer>();
	}
	
	/**This method verifies that the CommonObj10 is completed
	 * the objective is completed if there are eight tiles of the same type. 
	 * There are no restrictions on the position of these tiles.
	 */

	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		shelf = currentPlayer.getShelf();
		int rows, cols;
		rows = shelf.length;
		cols = shelf[0].length;

		if (this.NumberOfFilledCells(shelf) > 7) { //check if there are at least 8 tiles
			// Iterate through all the cells of the shelf
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					int cont=0;
					for( Tile targetType : Tile.values()){ //counts for each type of tiles
						if(targetType.equals(shelf[i][j])&& !targetType.equals(Tile.EMPTY)){
							cont++;
							if(cont>7){
								if(super.notCompletedYet(currentPlayer, hasCompletedID)) {
									return super.pointsMethod();
								}
							}
						}
					}
				}
			}
		}
		return 0;
	}



/**
 * @param matrix
 * 
 */
public int NumberOfFilledCells(Tile[][] matrix) { //check if there are at least 8 tiles
	int count = 0;
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[i].length; j++) {
			if (matrix[i][j] != Tile.EMPTY) {
				count++;
			}
		}
	}
	return count;

}

}
