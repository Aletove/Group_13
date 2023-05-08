package game;
/**
 * Mancano i commenti di tutto. 
 * @author Aletive
 *
 */
public class Shelf {
	Tile matrix[][];//cambiare a Tile il tipo
	
	public Shelf() {
		matrix=new Tile[6][5];//utilizzare delle costanti oppure il metodo .lenght all'interno del codice.
	}
	
	public int NumberOfEmptyCells(){
		int count=0;
		for(int i=0;i<6;i++) {
			for (int j=0;j<5;j++) {
				if(matrix[i][j]==0) {
					count++;
				}
			}
		}
		return count;
	}
	public int NumberOfEmptyCellsOnColumn(int column){
	    int count=0;
	    for (int i=0;i<6;i++){
	        if(matrix[i][column]==0){
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
	    for(int i=0;i<6;i++) {
			for (int j=0;j<5;j++) {
			    if(matrix[i][j]==0){
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
