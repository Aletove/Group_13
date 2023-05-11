package Game;

import java.util.*;

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
	 * @return true if the filling of column has done successfully  false
	 */
	public boolean fillColumn(int column,ArrayList<Tile> tiles) {
		if(isPlaceable(column,tiles.size())) {
			int firstempty=0;
			for(int i=this.matrix.length-1;i>=0;i--){
			    if(this.matrix[i][column]==null) {
			    	firstempty=i;
			    	break;
			    }
			}
			for(int i=0;i<tiles.size();i++) {
				this.matrix[firstempty+i][column]=tiles.get(i);
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * print the shelf
	 */
	public String toString(){
	    String s="";
	    for(int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix[i].length;j++) {
			    if(matrix[i][j]==null){
			        s+="0\t";
			    }else{
			        s+=matrix[i][j]+"\t";
			    }
			}
			s+="\n";
		}
		return s;
	}
	/**
	 * 
	 * @param t
	 * @return the number of adjacent tile passed as parameter
	 */
	public int adjacentTilescount(Tile t){
        int cont=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                if(this.matrix[i][j].equals(t)){
                    if(i==0&&j==0){
                        if(this.matrix[i][j].equals(this.matrix[i][j+1]) || this.matrix[i][j].equals(this.matrix[i+1][j]))
                            cont++;
                    }
                    if(i==0&&j==columns-1){
                        if(this.matrix[i][j].equals(this.matrix[i][j-1]) || this.matrix[i][j].equals(this.matrix[i+1][j]))
                            cont++;
                    }
                    if(i==rows-1&&j==0){
                        if(this.matrix[i][j].equals(this.matrix[i-1][j]) || this.matrix[i][j].equals(this.matrix[i][j+1]))
                            cont++;
                    }
                    if(i==rows-1&&j==columns-1){
                        if(this.matrix[i][j].equals(this.matrix[i][j-1]) || this.matrix[i][j].equals(this.matrix[i-1][j]))
                            cont++;
                    }
                    if(i==0&&j>0&&j<columns-1){
                        if(this.matrix[i][j].equals(this.matrix[i+1][j]) || this.matrix[i][j].equals(this.matrix[i][j-1]) || this.matrix[i][j].equals(this.matrix[i][j+1]))
                            cont++;
                    }
                    if(i==rows-1&&j>0&&j<columns-1){
                        if(this.matrix[i][j].equals(this.matrix[i-1][j]) || this.matrix[i][j].equals(this.matrix[i][j-1]) || this.matrix[i][j].equals(this.matrix[i][j+1]))
                            cont++;
                    }
                    if(j==0&&i>0&&i<rows-1){
                        if(this.matrix[i][j].equals(this.matrix[i][j+1]) || this.matrix[i][j].equals(this.matrix[i-1][j]) || this.matrix[i][j].equals(this.matrix[i+1][j]))
                            cont++;
                    }
                    if(j==columns-1&&i>0&&i<rows-1){
                        if(this.matrix[i][j].equals(this.matrix[i][j-1]) || this.matrix[i][j].equals(this.matrix[i-1][j]) || this.matrix[i][j].equals(this.matrix[i+1][j]))
                            cont++;
                    }
                    if(i>0&&j>0&&i<rows-1&&j<columns-1){
                        if(this.matrix[i][j].equals(this.matrix[i][j+1]) ||this.matrix[i][j].equals(this.matrix[i][j-1]) || this.matrix[i][j].equals(this.matrix[i+1][j]) ||this.matrix[i][j].equals(this.matrix[i-1][j]))
                            cont++;
                    }
                }
            }
        }
        return cont;
    }
	/**
	 * 
	 * @return the total score of adjacent tiles based on the number of the adjacent tiles of the same type. 
	 */
    public int adjacentTilesScore(){
        int count=0;
        Tile t[]=new Tile[6];;
        c[0]='r';
        c[1]='c';
        c[2]='t';
        c[3]='g';
        c[4]='l';
        c[5]='b';
        for(int i=0;i<6;i++){
            if(adjacentTilescount(t[i])==3){
                count+=2;
            }
            if(adjacentTilescount(t[i])==4){
                count+=3;
            }
            if(adjacentTilescount(t[i])==5){
                count+=5;
            }
            if(adjacentTilescount(t[i])>=6){
                count+=8;
            }
        }
        return count;
    }

}
