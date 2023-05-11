package Game;
import Game.Cell;
import Game.Bag;
import Game.Tile;
public class Board {

	private int SIZE=9;

	private Cell[][] matrix = new Cell[SIZE][SIZE];

	private int x, y, index, nPlayers;
	private int[] picAreaRows[];
	private int[] pickAreaColumns[];
	
	Bag bag = new Bag();

	private boolean state;

	public void setPlayers(int nPlayers) {
		this.nPlayers = nPlayers;
	}
	
	private Board() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				matrix[i][j] = new Cell(i, j, false, index);
				matrix[i][j] = null;
			}
		}	

		//celle non usabili:
		matrix[0][0].setIndex(0);
		matrix[0][1].setIndex(0);
		matrix[0][2].setIndex(0);
		matrix[0][5].setIndex(0);
		matrix[0][6].setIndex(0);
		matrix[0][7].setIndex(0);
		matrix[0][8].setIndex(0);
		matrix[1][0].setIndex(0);
		matrix[1][1].setIndex(0);
		matrix[1][2].setIndex(0);
		matrix[1][6].setIndex(0);
		matrix[1][7].setIndex(0);
		matrix[1][8].setIndex(0);
		matrix[2][0].setIndex(0);
		matrix[2][1].setIndex(0);
		matrix[2][2].setIndex(0);
		matrix[2][3].setIndex(0);
		matrix[3][0].setIndex(0);
		matrix[5][8].setIndex(0);
		matrix[6][0].setIndex(0);
		matrix[6][1].setIndex(0);
		matrix[6][7].setIndex(0);
		matrix[6][8].setIndex(0);
		matrix[7][0].setIndex(0);
		matrix[7][1].setIndex(0);
		matrix[7][2].setIndex(0);
		matrix[7][6].setIndex(0);
		matrix[7][7].setIndex(0);
		matrix[7][8].setIndex(0);
		matrix[8][0].setIndex(0);
		matrix[8][1].setIndex(0);
		matrix[8][2].setIndex(0);
		matrix[8][3].setIndex(0);
		matrix[8][6].setIndex(0);
		matrix[8][7].setIndex(0);
		matrix[8][8].setIndex(0);

		//celle per 2 giocatori: 
		matrix[1][3].setIndex(1);
		matrix[1][4].setIndex(1);
		matrix[2][3].setIndex(1);
		matrix[2][4].setIndex(1);
		matrix[2][5].setIndex(1);
		matrix[3][2].setIndex(1);
		matrix[3][3].setIndex(1);
		matrix[3][4].setIndex(1);
		matrix[3][5].setIndex(1);
		matrix[3][6].setIndex(1);
		matrix[3][7].setIndex(1);
		matrix[4][1].setIndex(1);
		matrix[4][2].setIndex(1);
		matrix[4][3].setIndex(1);
		matrix[4][4].setIndex(1);
		matrix[4][5].setIndex(1);
		matrix[4][6].setIndex(1);
		matrix[4][7].setIndex(1);
		matrix[5][1].setIndex(1);
		matrix[5][2].setIndex(1);
		matrix[5][3].setIndex(1);
		matrix[5][4].setIndex(1);
		matrix[5][5].setIndex(1);
		matrix[5][6].setIndex(1);
		matrix[6][3].setIndex(1);
		matrix[6][4].setIndex(1);
		matrix[6][5].setIndex(1);
		matrix[7][4].setIndex(1);
		matrix[7][5].setIndex(1);

		//celle per 3 giocatori
		matrix[0][3].setIndex(2);
		matrix[2][2].setIndex(2);
		matrix[2][6].setIndex(2);
		matrix[3][8].setIndex(2);
		matrix[5][0].setIndex(2);
		matrix[6][2].setIndex(2);
		matrix[6][6].setIndex(2);
		matrix[8][5].setIndex(2);

		//celle per 4 giocatori:

		matrix[0][4].setIndex(3);
		matrix[1][5].setIndex(3);
		matrix[3][1].setIndex(3);
		matrix[4][0].setIndex(3);
		matrix[4][8].setIndex(3);
		matrix[5][7].setIndex(3);
		matrix[7][3].setIndex(3);
		matrix[8][4].setIndex(3);

		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(nPlayers == 2) {
					if(matrix[i][j].index == 1) {
						matrix[i][j].setState(true);;
					}
				} else if(nPlayers == 3){
					if(matrix[i][j].index == 2 || matrix[i][j].index == 1) {
						matrix[i][j].setState(true);;
					}
					
				} else if(nPlayers == 4){
					if(matrix[i][j].index == 3 || matrix[i][j].index == 2 || matrix[i][j].index == 1) {
						matrix[i][j].setState(true);;
					}
					
				}

			}
		}	


	}




	public void pickTiles(int picAreaRows[], int pickAreaColumns[]) {


	}
	public void fillBoard(Bag bag) {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				
		}	
	}
	public void isPickable() {

	}
}
