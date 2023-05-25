package Game;
import personalObj.*;
public class Player {

	private String name;
	private final int id;
	private PersonalObj pGoal;
	private int cGoalPoints
	private boolean isFirst;
	private Shelf pShelf;

	/**
	 * @author Maria Lamara
	 * The constructor define player
	 * @param id player
	 * @param name player
	 * @param pGoal player
	 */
	
	public Player(int id, String name, PersonalObj pGoal) {
		this.id = id;
		this.pShelf = new Shelf();
		this.name = name;
		this.pGoal = pGoal;
		cGoalPoints = 0;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setIsFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public int getCGoalPoints() {
		return cGoalPoints;
	}

	public void setCGoalPoints(int cGoalPoints) {
		this.cGoalPoints = cGoalPoints;
	}

	public int totalPoints() {
		int total = 0;
		total += pGoalPoints();
		total += cGoalPoints;
		total += pShelf.adjacentTilesScore();
		return total;
	}

	private int pGoalPoints() {
		Tile[][] matrix = pShelf.getShelf();
		int rows = matrix.length;
		int cols = matrix[0].length;
		int cont = 0;
		int points=0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j].equals(pGoal[i][j]) && !pGoal[i][j].equals(Tile.EMPTY)) {
					cont++;
				}
			}
		}
		switch (cont) {
		case 1:
			points += 1;
			break;
		case 2:
			points += 2;
			break;
		case 3:
			points += 4;
			break;
		case 4:
			points += 6;
			break;
		case 5:
			points += 9;
			break;
		case 6:
			points += 12;
			break;
		default: 
			System.out.println("There is not any tile matching the personal goal card.");
		}
		return points;
	}

	public boolean checkShelf() {
		return this.pShelf.isFull();
	}

	public void fillShelfColumn(int col,Tile [] tiles) {
		pShelf.fillColumn(col,tiles);
	}

	public Tile[][] getShelf() {
		return pShelf.getShelf();
	}

}
