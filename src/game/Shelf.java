package game;

import java.util.ArrayList;

public class Shelf {
	private final int rows=6;
	private final int columns=5;
	private Tile matrix[][];
	
	public Shelf() {
		matrix=new Tile[rows][columns];
	}
	/**
	 * 
	 * @return the matrix of shelf
	 */
	public Tile[][] getShelf() {
		return matrix;
	}
	/**
	 * 
	 * @return the number of empty cells on the shelf
	 */
	public int NumberOfEmptyCells(){
		int count=0;
		for(int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]==null) {
					count++;
				}
			}
		}
		return count;
	}
	/**
	 * 
	 * @param column
	 * @return the number of empty cells on the single column
	 */
	public int NumberOfEmptyCellsOnColumn(int column){
	    int count=0;
	    for (int i=0;i<matrix.length;i++){
	        if(matrix[i][column]==null){
	            count++;
	        }
	    }
	    return count;
	}
	/**
	 * 
	 * @return true if the shelf is full
	 */
	public Boolean isFull() {
		if(this.NumberOfEmptyCells()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * 
	 * @param column
	 * @param noftiles
	 * @return true if there is enough empty cells on the column for the number of tiles
	 */
	public Boolean isPlaceable(int column,int noftiles) {
		if(this.NumberOfEmptyCellsOnColumn(column)<=noftiles) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * a method that fills the column with the tiles passed
	 * @param column
	 * @param tiles
	 * @return true if the filling of column has been done successfully  false
	 */
	public boolean fillColumn(int column, ArrayList<Tile> tiles) {
		if(isPlaceable(column,tiles.size())) {
			int firstempty=0;
			//searches for the first empty element in the specified column
			for(int i = 0; i < matrix.length; i++){
			    if(this.matrix[i][column].equals(null)) {
			    	firstempty=i;
			    }
			}
			for(int i=0;i<tiles.size();i++) {
				this.matrix[firstempty+i][column]=tiles.remove(i);
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return an array of two positions, in the first element we have the column with the maximum number of empty cells. in the second element we have the number of empty tiles if it is smaller than 3.
	 */
	public int[] nMaxTiles() {
		int cont=0;
		int colCon[] = new int[2];
		for(int i=0;i<columns;i++) {
			if(cont<this.NumberOfEmptyCellsOnColumn(i)) {
				cont=this.NumberOfEmptyCellsOnColumn(i);
				colCon[0] = i;
				colCon[1] = cont;
			}
		}
		if(colCon[1] > 3) {
    		colCon[1] = 3;
    	}
		return colCon;
	}
	
	/**
	 * a method that use the DFS algorithm,
	 * a recursive algorithm that uses the backtracking principle ,
	 * to calculate the score obtained
	 * @return the score obtained
	 */
	
	public int adjacentTilesScore() {
	    int score = 0;
	    boolean[][] discovered = new boolean[6][5]; // a boolean used for the DFS algorithm to mark the counted cell
	    for(int i=0;i<6;i++) { //initialize the boolean matrix to false
	    	for(int j=0;j<5;j++) {
	    		discovered[i][j]=false;
	    	}
	    }
	    Tile [] tile = new Tile[] {Tile.CATS,Tile.BOOKS,Tile.FRAMES,Tile.GAMES,Tile.PLANTS,Tile.TROPH};// an array that contain all the types of tile
	    for(int i=0;i<tile.length;i++) {//a loop that repeat the following operations for all type of tile
	    	for (int j = 0; j < matrix.length; j++) {
		        for (int k = 0; k < matrix[j].length; k++) {
		            if (matrix[j][k].equals(tile[i]) && !discovered[j][k]) { //find the cell that contain the same type of tile contained in tile[i] and not counted yet
		                int groupSize = dfs(j, k, tile[i], discovered); //groupSize contain the number of adjacent tile on the same group that obtained from the dfs method;
		                if (groupSize == 3) {
		                    score += 2;
		                } else if (groupSize == 4) {
		                    score += 3;
		                } else if (groupSize == 5) {
		                    score += 5;
		                } else if (groupSize >= 6) {
		                    score += 8;
		                }
		            }
		        }
		    }	
	    }
	    return score;
	}
	/**
	 * the method that implement the DFS algorithm
	 * @param i contain the position of the current tile
	 * @param j contain the position of the current tile
	 * @param tile the tile founded by the method adjacentTilesScore on the first round of the recursion
	 * @param discovered a matrix of boolean to mark the cell counted
	 * @return the number of adjacent tile on the same group
	 */
	private int dfs(int i, int j, Tile tile, boolean[][] discovered) {
		/*the base condition of the recursion method that return 0 if the position is not available on the matrix
			or the new cell not contain the same type of the tile, or the cell is already counted
		 * */
	    if (i < 0 || i >= rows || j < 0 || j >= columns || !(matrix[i][j].equals(tile)) || discovered[i][j]) { 
	    	return 0;
	    }
	    discovered[i][j] = true; //mark the current cell as discovered 
	    /*if the cell contain the same type of the tile contained on the precedent cell
	     * return 1+ the number of tile of the adjacent tile and call the same method to do the same check
	     */
	    return 1 + dfs(i - 1, j, tile, discovered) + dfs(i + 1, j, tile, discovered)
	            + dfs(i, j - 1, tile, discovered) + dfs(i, j + 1, tile, discovered);
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
			for (int j=0;j<matrix[i].length;j++) {
				s+=matrix[i][j]+"\t";
			}
			s+="\n";
		}
		return s;
	}
}
