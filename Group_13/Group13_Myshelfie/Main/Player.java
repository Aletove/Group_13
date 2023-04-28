package Main;

public class Player {

	private String name;
	private final String id;
	public PersonalObjectives pObjective;
	public int cObjPoints;
	public boolean isFirst;
	// public Shelf shelf;

	public Player(String newId) {
		this.id = newId;
		//this.shelf=new Shelf();
	}

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
		// TODO: waiting for others
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
		int total=0;
		for( int i=0 ; i<this.pObjective.goalTiles.length;i++) {
			/*if(this.shelf.isTileFilled(this.pObjective.goalTiles[i].x,this.pObjective.goalTiles[i].y)) {
				switch(i) {
					case 0:
						total+=1;
						break;
					case 1:
						total+=2;
						break;
					case 2:
						total+=4;
						break;
					case 3:
						total+=6;
						break;
					case 4:
						total+=9;
						break;
					case 5:
						total+=12;
						break;
				}
			}*/
		}
		return total;
	}
	
	public boolean checkShelf() {
		//return this.shelf.isFull();
		return true;
	}
	public boolean fillShelf() {
		//return this.shelf.fillColumn(column,tiles);
		return true;
	}
	

}
