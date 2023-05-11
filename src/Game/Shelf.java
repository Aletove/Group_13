package Game;
/**
 * Mancano i commenti di tutto. 
 * @author Aletive
 *
 */
public class Shelf {
	final int rows=6;
	final int columns=5;
	Tile matrix[][];
	
	public Shelf() {
		matrix=new Tile[rows][columns];
	}
	
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
	public int NumberOfEmptyCellsOnColumn(int column){
	    int count=0;
	    for (int i=0;i<matrix.length;i++){
	        if(matrix[i][column]==null){
	            count++;
	        }
	    }
	    return count;
	}
	
	public Boolean isFull() {
		if(this.NumberOfEmptyCells()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean isPlaceable(int column) {
		if(this.NumberOfEmptyCellsOnColumn(column)==0) {
			return false;
		}else {
			return false;
		}
	}
	
	public void fillColumn(int column,Tile tile[]) {
		
	}
	
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

	public Tile[][] getShelf() {
		return matrix;
	}
}
