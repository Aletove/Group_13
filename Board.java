package Game;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

	private int SIZE=9;
	private int nPlayers;
	private int[][] mold =  {
			{0, 0, 0, 3, 4, 0, 0, 0, 0},
			{0, 0, 0, 2, 2, 4, 0, 0, 0},
			{0, 0, 3, 2, 2, 2, 3, 0, 0},
			{0, 4, 2, 2, 2, 2, 2, 2, 3},
			{4, 2, 2, 2, 2, 2, 2, 2, 4},
			{3, 2, 2, 2, 2, 2, 2, 4, 0},
			{0, 0, 3, 2, 2, 2, 3, 0, 0},
			{0, 0, 0, 4, 2, 2, 0, 0, 0},
			{0, 0, 0, 0, 4, 3, 0, 0, 0},
	};
	private	Tile[][] matrix;
	private Bag boardBag = new Bag();
	private static final int[][] DIRECTIONS = {{1, 0}, {0, -1}, {0, 1}}; // Directions: down, left, right. the top is excluded


	/**
	 * 
	 * @param nPlayer
	 */
	public Board(int nPlayer) {

		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(mold[i][j] > nPlayers) {
					matrix[i][j] = Tile.EMPTY;
				}
			}
		}	
	}

	/**
	 * checks if the chosen tiles are allowed to be picked 
	 * @param x
	 * @param y
	 * @return true if tiles can be picked
	 */
	public boolean isPickable(int[] x, int[] y) {
		boolean temp = false;
		for(int i=0; i<x.length; i++) {
			for (int j=0; j<y.length; j++) {
				for (int[] direction : DIRECTIONS) {
					int newRow = x[i] + direction[0];
					int newCol = y[j] + direction[1];

					if(matrix[newRow][newCol].equals(null) || matrix[newRow][newCol].equals(Tile.EMPTY)) {
						temp = true;
					}

				}
			}
		}
		return temp;

	}	

	/**
	 * 
	 * @param pickAreaRows
	 * @param pickAreaColumns
	 * @return array with the selected tiles
	 */
	public ArrayList<Tile> pickTiles(int pickAreaRows[], int pickAreaColumns[]) {
		ArrayList<Tile> picked = new ArrayList<Tile>();
		if(isPickable(pickAreaRows, pickAreaColumns)) {
		for(int i=0; i<pickAreaRows.length; i++) {
			for(int j=0; j<pickAreaColumns.length; j++) {

					picked.add(matrix[pickAreaRows[i]][pickAreaColumns[j]]);

					matrix[pickAreaRows[i]][pickAreaColumns[j]] = Tile.EMPTY;
				}
			}
		}

		if(isEmpty()) {
			fillBoard(boardBag);
		}

		return picked;
	}

	/**
	 * fill the board with tiles from the bag
	 * @param boardBag
	 */
	public void fillBoard(Bag boardBag) {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(matrix[i][j] != Tile.EMPTY && matrix[i][j] != null) {
					matrix[i][j] = Tile.EMPTY;
				}
				if(matrix[i][j] == Tile.EMPTY) {
					matrix[i][j] = boardBag.getTile();
				}
			}
		}
	}

	private boolean findAdjacent(int row, int col) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean flag = false;

		// Boundary and tile type check
		if (row < 0 || row >= rows || col < 0 || col >= cols) {
			return false;
		}
		if(!matrix[row][col].equals(Tile.EMPTY)  && !matrix[row][col].equals(null)) {
			flag = true;
		}

		for (int[] direction : DIRECTIONS) {
			int newRow = row + direction[0];
			int newCol = col + direction[1];

			findAdjacent(newRow, newCol);
		}

		return flag;
	}

	/**
	 * checks the remaining tiles on the board and refills it if there are no adjacent tiles
	 */

	public boolean isEmpty() {
		boolean control = false;


		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE && !control; j++) {

				control = findAdjacent(i, j);

			}
		}


		if(control == false) {
			fillBoard(boardBag);
		}
		return control;

	}

	@Override
	public String toString() {
		return "Board [matrix=" + Arrays.toString(matrix) + "]";
	}
}
