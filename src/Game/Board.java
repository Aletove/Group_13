package Game;

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
			{0, 0, 0, 2, 2, 2, 0, 0, 0},
			{0, 0, 0, 0, 4, 3, 0, 0, 0},
	};
	private	Tile[][] matrix;
	private Bag boardBag = new Bag();

	public Board(int nPlayer) {

		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(mold[i][j]==nPlayers) {
					matrix[i][j] = Tile.EMPTY;
				}
			}
		}	
	}

	public boolean isPickable(int x, int y) {
		boolean temp = false;
		if(matrix[x-1][y] == null  || matrix[x][y-1] == null  || matrix[x+1][y] == null  || matrix[x][y+1] == null) {
			temp = true;
		}

		return temp;
	}	

	public void pickTiles(int pickAreaRows[], int pickAreaColumns[]) {
		for(int i=0; i<pickAreaRows.length; i++) {
			for(int j=0; j<pickAreaColumns.length; j++) {
				if(!isPickable(i, j)) {
					System.out.println("Scelta non valida");
				}
			}
		}

	}
	public void fillBoard(Bag boardBag) {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(matrix[i][j] == Tile.EMPTY) {
					matrix[i][j] = boardBag.getTile();
				}
			}
		}
	}

}
