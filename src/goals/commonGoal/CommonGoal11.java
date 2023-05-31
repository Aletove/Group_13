package goals.commonGoal;

import game.*;
import goals.*;
import java.util.*;

public class CommonGoal11 extends Goal {
	private ArrayList<Integer> hasCompletedID;

	/**
	 * The constructor generates the array list points, based on the number of
	 * players.
	 * 
	 * @param nPlayers
	 */
	public CommonGoal11(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<Integer>();
	}

	/**
	 * This method verifies that the CommonObj11 is completed the objective is
	 * completed if five columns of increasing or decreasing height: starting with
	 * the first column on the left or right, each following column should contain
	 * one more tile. The tiles may be of any type.
	 */
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		shelf = currentPlayer.getShelf();
		int rows, cols;
		rows = shelf.length;
		cols = shelf[0].length;
		int previousCount = 0;
		int currentCount = 0;
		boolean isAscending = false;
		boolean isDescending = false;

		for (int j = 0; j < cols; j++) { // The following cycles verify player's shelf
			for (int i = 0; i < rows; i++) {
				if (shelf[i][j].equals(Tile.EMPTY)) { // this condition sums the empty cells in a column
					currentCount++;
				}
			}
			// on the difference between the sum of empty cells of two adjacent columns I
			// can determine if the condition of increasing or decreasing is verified
			if (previousCount != 0) {
				if ((previousCount - currentCount) == 1 && isDescending == false) {
					isAscending = true;
				} else if ((previousCount - currentCount) == -1 && isAscending == false) {
					isDescending = true;
				} else { // gets into this condition if it is neither increasing nor decreasing (e.g.
							// pyramid shape)
					isDescending = false;
					isAscending = false;
					break;
				}
			}
			previousCount = currentCount;
			currentCount = 0; // at the end of the iteration resets the variable
		}

		if (isDescending == true || isAscending == true) {
			if (super.notCompletedYet(currentPlayer, hasCompletedID)) {
				return super.pointsMethod();
			}
		}
		return 0;
	}

}
