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
				if(mold[i][j] >= nPlayers) {
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
	public boolean isPickable(int x, int y) {
		boolean temp = false;
		if(matrix[x-1][y] == null  || matrix[x][y-1] == null  || matrix[x+1][y] == null || matrix[x][y+1] == null 
				|| matrix[x-1][y] == Tile.EMPTY  || matrix[x][y-1] == Tile.EMPTY  || matrix[x+1][y] == Tile.EMPTY  || matrix[x][y+1] == Tile.EMPTY) {
			temp = true;
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
		for(int i=0; i<pickAreaRows.length; i++) {
			for(int j=0; j<pickAreaColumns.length; j++) {
				if(isPickable(pickAreaRows[i], pickAreaColumns[j])) {

					picked.add(matrix[pickAreaRows[i]][pickAreaColumns[j]]);

					matrix[pickAreaRows[i]][pickAreaColumns[j]] = Tile.EMPTY;
				}
			}
		}

		isEmpty();

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

	private boolean findAdjacent(Tile[][] matrix, int row, int col) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		// Boundary and tile type check
		if (row < 0 || row >= rows || col < 0 || col >= cols) {
			return false;
		}
		for (int[] direction : DIRECTIONS) {
			int newRow = row + direction[0];
			int newCol = col + direction[1];
	            
			findAdjacent(matrix, newRow, newCol);
		}
		return true;
	}

	/**
	 * checks the remaining tiles on the board and refills it if there are no adjacent tiles
	 */

	public void isEmpty() {
		boolean control = false;
		
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE && !control; j++) {
				if(matrix[i][j] != Tile.EMPTY && matrix[i][j] != null) {
					/*if((matrix[i-1][j] != null || matrix[i-1][j] != Tile.EMPTY) 
							|| (matrix[i][j-1] != null || matrix[i][j-1] != Tile.EMPTY) 
							|| (matrix[i+1][j] != null || matrix[i+1][j] != Tile.EMPTY) 
							|| (matrix[i][j+1] != null || matrix[i][j+1] != Tile.EMPTY)) {*/

						control = findAdjacent(matrix, i, j);
				}
			}
		}
		
		
		if(control == false) {
			fillBoard(boardBag);
		}

	}

	@Override
	public String toString() {
		return "Board [matrix=" + Arrays.toString(matrix) + "]";
	}
}
