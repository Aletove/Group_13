package objectives.personalObj;
import game.*;
public class PersonalObj{
	private Tile objMatrix [][];

	public PersonalObj(Tile matrix [][]) {
		this.objMatrix=matrix;
	}
	
	public Tile[][] getObjMatrix() {
		return objMatrix;
	}
	public void setObjMatrix(Tile objMatrix[][]) {
		this.objMatrix = objMatrix;
	}
	
	
	public int isCompleted(Player currentPlayer) {

		return 0;
	}

}