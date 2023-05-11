package objectives.personalObj;
import game.*;
import objectives.*;
public class PersonalObj implements Objective{
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
	
	@Override
	public int isCompleted(Player currentPlayer) {

		return 0;
	}

}