package Game;

import java.util.ArrayList;

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
	/**
	 * checks the remaining tiles on the board and refills it if there are no adjacent tiles
	 */
	public void isEmpty() {
		int n_single = 0;
		int n_used = 0;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(matrix[i][j] != Tile.EMPTY && matrix[i][j] != null) {
					n_used++;
					if((matrix[i-1][j] == null  || matrix[i-1][j] == Tile.EMPTY) 
							&& (matrix[i][j-1] == null || matrix[i][j-1] == Tile.EMPTY) 
							&& (matrix[i+1][j] == null || matrix[i+1][j] == Tile.EMPTY) 
							&& (matrix[i][j+1] == null || matrix[i][j+1] == Tile.EMPTY)) {
							
						n_single++;

					}
				}
			}
		}
		if(n_single == n_used) {
			fillBoard(boardBag);
		}
	}
}
