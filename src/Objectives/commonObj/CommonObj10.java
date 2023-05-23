package commonObj;
import Game.Player;
import Game.Tile;
import Objectives.*;
import java.util.ArrayList;

public class CommonObj10 extends Objective {
	private ArrayList<Player> hasCompleted;

	/**
	 * The constructor generates the array list points, based on the number of
	 * players.
	 * 
	 * @param nPlayers
	 */
	public CommonObj10(int nPlayers) {
		super(nPlayers);
		hasCompleted = new ArrayList<Player>();

	}

	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		shelf = currentPlayer.getShelf();
		int rows, cols;
		int contCats = 0;
		int contBooks = 0;
		int contFrames = 0;
		int contTrophies = 0;
		int contPlants = 0;
		boolean objectiveReached = false;
		rows = shelf.length;
		cols = shelf[0].length;

		if (this.NumberOfFilledCells(shelf) > 7) {
			for (int i = 0; i < cols; i++) {
				for (int j = 0; j < rows; j++) {
					if (!shelf[i][j].equals(null)) {
						if (shelf[i][j].equals(Tile.CATS))
							contCats++;

						else if (shelf[i][j].equals(Tile.BOOKS))
							contBooks++;

						else if (shelf[i][j].equals(Tile.FRAMES))
							contFrames++;

						else if (shelf[i][j].equals(Tile.TROPHIES))
							contTrophies++;

						else if (shelf[i][j].equals(Tile.FRAMES))
							contPlants++;

					}
				}
			}
// Check if the objective was reached
			if (contCats > 7 || contBooks > 7 || contFrames > 7 || contTrophies > 7 || contPlants > 7) {
				objectiveReached = true;
			} else
				objectiveReached = false;

			if (objectiveReached) {
				System.out.println("Objective reached: eight tiles of the same type.");
			} else
				System.out.println("Objective not reached.");
		}
	}

	public int NumberOfFilledCells(Tile[][] matrix) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != null) {
					count++;
				}
			}
		}
		return count;

	}

}
