package objectives.commonObj;
import game.*;
import objectives.*;
import java.util.ArrayList;


public class CommonObj2 extends Objective{
	private ArrayList<Player> hasCompleted;
	
	
	
	/**The constructor generates the array list hasCompleted,
	 * to store the players that have already completed the common objective
	 * @param nPlayers
	 */
	public CommonObj2(int nPlayers) {
		super(nPlayers);
		hasCompleted = new ArrayList<Player>();
		
		
	}
	/**Method to verify the accomplishment of the common objective
	 * Card number 2, objectives at the four vertices
	 */
	@Override
	public int isCompleted(Player currentPlayer) {
		Tile[][] shelf;
		shelf = currentPlayer.getShelf();
		
		int maxColumns = shelf[0].length;//i used the element 0, since the matrix is static and every column is the same
		int maxRows = shelf.length;
		
		//the following if statement verifies that all the elements in the four vertices are equal
		if(shelf[0][0].getLogicType().equals(shelf[0][maxColumns].getLogicType()) && shelf[maxRows][0].getLogicType().equals(shelf[0][maxColumns].getLogicType()) && shelf[0][0].getLogicType().equals(shelf[maxRows][maxColumns].getLogicType()) && shelf[0][0].getLogicType() != null) {
			if(super.notCompletedYet(currentPlayer, hasCompleted)) {
				hasCompleted.add(currentPlayer);
				return super.pointsMethod();
			}
		}
		
		return 0;
	}
	
	
	

}