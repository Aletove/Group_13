package Objectives.commonObj;

import Game.Player;
import Game.Tile;
import Objectives.*;
import java.util.ArrayList;

public class CommonObj11 extends Objective {
	private ArrayList<Player> hasCompleted;

	/**
	 * The constructor generates the array list points, based on the number of
	 * players.
	 * 
	 * @param nPlayers
	 */
	public CommonObj11(int nPlayers) {
		super(nPlayers);
		hasCompleted = new ArrayList<Player>();

	}

	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		shelf = currentPlayer.getShelf();
		boolean objectiveReached = false;
		boolean isNotCompleted = true;
		boolean isAscending = false;
		boolean isDescending = false;

		// First check about empty cells
		if (this.isFirstRowEmpty(shelf)) {
			isAscending = this.isAsce(shelf);
			isDescending = this.isDesce(shelf);

			if (!isDescending && !isAscending) {
				objectiveReached = false;
			} else if (isDescending && isAscending) {
				// is impossible
			} else if (isDescending || isAscending) {
				objectiveReached = true;

			}
			// check if the objective is reached
			if (objectiveReached) {
				System.out.println("Objective reached!");
				return 0;
			} else {
				System.out.println("Objective not reached.");
			}

		}

	}

	/**
	 *
	 * @param cell
	 * @return
	 */
	public boolean isFilled(Tile cell) {
		if (cell != null) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param shelf
	 * @return
	 */
	public boolean isFirstRowEmpty(Tile[][] shelf) {
		// Check if cell at r:2 c:2 is empty
		if (!this.isFilled(shelf[2][2])) {
			// check if the top row is empty
			for (int i = 0; i < 4; i++) {
				if (!this.isFilled(shelf[0][i])) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * @param shelf
	 * @return
	 */

	public boolean isDesce(Tile[][] shelf) {
		for (int i = 1; i < 6; i++) {
			// check if is ascendant from the [1,0] cell to [5,4] diagonally, if there some
			// empty cell return false and checked if in the precending row, same column the
			// cell is empty
			for (int j = 0; j < 5; j++) {
				if (!this.isFilled(shelf[i][j]) || (this.isFilled(shelf[i - 1][j]))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 *
	 * @param shelf
	 * @return
	 */

	public boolean isAsce(Tile[][] shelf) {
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < 4; j++) {
				if ((i + j) == 5) { //
					// the check diagonally from [0,4] cell and ends to [4,0], if there are some
					// empty cells return false and checked if in the precending row, same column
					// the cell is empty
					if (!this.isFilled(shelf[i][j]) || (this.isFilled(shelf[i - 1][j]))) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
