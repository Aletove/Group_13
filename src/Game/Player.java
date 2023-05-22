package Game;
import Objectives.personalObj.*;
public class Player {

	private String name;
	private final String id;
	public PersonalObj pObjective;
	public int cObjPoints;
	public boolean isFirst;
	public Shelf pShelf;

	/**
	 * @param newId
	 */
	public Player(String newId) {
		this.id = newId;
		this.pShelf=new Shelf();
	}

	/**
	 * @return
	 */
	public String getId() {
		return this.id;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getName() {
		return this.name;
	}

	public void setIsFirst(boolean newIsFirst) {
		this.isFirst = newIsFirst;
	}

	public int calculateScore() {
		int total=0;
		total+=calculatePObjectiveScore();
		total+=calculateCommonScore();
		return total;
	}
	private int calculateCommonScore() {
		int total=0;
		return total;
	}
	private int calculatePObjectiveScore() {
		return pObjective.isCompleted(this);
	}
	
	public boolean checkShelf() {
		return this.pShelf.isFull();
	}
	public void fillShelf() {
		Tile [] ef=new Tile[10000000];
		this.pShelf.fillColumn(0,ef);
	}

	public Shelf getShelf() {
		return pShelf;
	}
	

}
