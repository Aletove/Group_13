package Main;

public class Shelf {
	char matrix[][];
	
	public Shelf() {
		matrix=new char[6][5];
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
}
