package goals.commonGoal;
import game.*;
import goals.*;
import java.util.*;

public class CommonGoal2 extends Goal{
	private ArrayList<String> hasCompletedID;

	
	
	/**The constructor generates the array list points,
	 * based on the number of players.
	 * @param nPlayers
	 */
	public CommonGoal2(int nPlayers) {
		super(nPlayers);
		hasCompletedID = new ArrayList<String>();
		
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
		if(shelf[0][0] == shelf[0][maxColumns] && shelf[maxRows][0] == shelf[0][maxColumns] && shelf[0][0] == shelf[maxRows][maxColumns] && shelf[0][0] != Tile.EMPTY) {
			if(super.notCompletedYet(currentPlayer, hasCompletedID)) {
				return super.pointsMethod();
			}
		}
		
		return 0;
	}
}