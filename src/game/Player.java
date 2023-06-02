package game;

import java.util.ArrayList;

public class Player {

	private String name;
	private final int id;
	private Tile [][] pGoal;
	private int points;
	private boolean isFirst;
	private Shelf pShelf;

	/**
	 * The constructor define player
	 * @param id player
	 * @param name player
	 * @param pGoal player
	 */
	
	public Player(int id, String name, Tile [][] pGoal) {
		this.id = id;
		this.pShelf = new Shelf();
		this.name = name;
		this.pGoal = pGoal;
		points = 0;
	}

	/**
	 * @return player's Id
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * @return player's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param isFirst
	 */
	public void setIsFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	/**
	 * @return if player is first
	 */
	public boolean isFirst() {
		return isFirst;
	}
	/**
	 * @return player's points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @param cGoalPoints
	 */
	public void setPoints(int cGoalPoints) {
		this.points = cGoalPoints;
	}

	public int totalPoints() {
		int total = 0;
		total += pGoalPoints();
		total += points;
		total += pShelf.adjacentTilesScore();
		return total;
	}
	/**
	 * @return personal goal score 
	 */
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
	/**
	 * 
	 * @return true if the shelf is full
	 */
	public boolean checkShelf() {
		return pShelf.isFull();
	}
	
	/**
	 * @return an array of two positions, in the first element we have the column with the maxinum number of empty cells. In the second element we have the number of tiles
	 */
	public int[] nMaxTiles() {
		return pShelf.nMaxTiles();
	}

	/**
	 * a method that fills the column with the tiles passed
	 * @param column
	 * @param tiles
	 * @return true if column has been filled correctly, otherwise false
	 */
	public boolean fillShelfColumn(int col, ArrayList<Tile> tiles) {
		return pShelf.fillColumn(col,tiles);
	}
	/**
	 * @return player's shelf
	 */
	public Tile[][] getShelf() {
		return pShelf.getShelf();
	}
	/**
	 * @return print player's shelf
	 */
	public String printShelf() {
		return pShelf.toString();
	}

	

}
