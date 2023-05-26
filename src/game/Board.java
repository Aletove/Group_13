package game;

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
	 * @param row
	 * @param col
	 * @return true if tiles can be picked
	 */
	public boolean isPickable(int[] row, int[] col) {
		boolean pickable = true;
		for(int i=0; i<row.length; i++) {
			for (int j=0; j<col.length; j++) {
				pickable = findAdjacent(row[i], col[j]);
			}
		}
		return pickable;
	}

	/**the method automatically makes the calls to the methods to fill the board as soon as it is empty
	 * 
	 * @param pickAreaRows
	 * @param pickAreaColumns
	 * @return array with the selected tiles
	 */
	public ArrayList<Tile> pickTiles(int pickAreaRows[], int pickAreaColumns[]) {
		ArrayList<Tile> picked = new ArrayList<Tile>();
		for(int i=0; i<pickAreaRows.length; i++) {
			for(int j=0; j<pickAreaColumns.length; j++) {

				picked.add(matrix[pickAreaRows[i]][pickAreaColumns[j]]);

				matrix[pickAreaRows[i]][pickAreaColumns[j]] = Tile.EMPTY;
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
				if(!matrix[i][j].equals(null)) {
					matrix[i][j] = boardBag.getTile();
				}
			}
		}
	}

	private boolean findAdjacent(int row, int col) {
		int rows = matrix.length;
		int cols = matrix[0].length;


		for (int[] direction : DIRECTIONS) {
			int newRow = row + direction[0];
			int newCol = col + direction[1];
			if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !matrix[newRow][newCol].equals(Tile.EMPTY) && !matrix[newCol][newRow].equals(null)) {
	            return true; // Found an adjacent tile that is not empty, nor null
	        }
	    }

	    return false; // No adjacent tiles found

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
		
		return control;

	}

	@Override
	public String toString(){
	    String s="";
	    
	    //build of the first row with all the indexs
		for (int j=0;j<matrix[0].length;j++) {
			s+=j+"\t";
		}
		s+="\n";	
		//build of the rest of the matrix in the string
	    for(int i=0;i<matrix.length;i++) {
	    	//puts the index of the row in the first element
	    	s+= i +"\t";
			for (int j=0;j<matrix[i].length;j++) {
				s+=matrix[i][j]+"\t";
			}
			s+="\n";
		}
		return s;
	}

	public int getMaxRows() {
		return matrix.length;
	}

	public int getMaxColumns() {
		return matrix[0].length;
	}
}